package com.willy.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.willy.game.FlappyBird;
import com.willy.game.sprites.Bird;
import com.willy.game.sprites.Tube;

import java.util.ArrayList;
import java.util.List;

public class PlayState extends State {

    private static final int TUBE_SPACING = 125;
    private static final int TUBE_COUNT = 4;

    private Bird bird;
    private Texture background;

    private List<Tube> listOfTubes;

    public PlayState(GameStateManager gameStateManager) {
        super(gameStateManager);
        bird = new Bird(50, 300);
        background = new Texture("bg.png");
        listOfTubes = createListOfTubes();
        camera.setToOrtho(false, FlappyBird.WIDTH / 2, FlappyBird.HEIGTH / 2);
    }

    private List<Tube> createListOfTubes() {
        List<Tube> listOfTubes = new ArrayList<>();
        for (int i = 1 ; i <= TUBE_COUNT ; i++) {
            listOfTubes.add(new Tube(i * (TUBE_SPACING + Tube.TUBE_WIDTH)));
        }
        return listOfTubes;
    }

    @Override
    public void handleInput() {
        if (Gdx.input.justTouched()) {
            bird.jump();
        }
    }

    @Override
    public void update(Float deltaTime) {
        handleInput();
        bird.update(deltaTime);
        camera.position.x = bird.getPosition().x + 80;

        for (Tube tube : listOfTubes) {
            if (camera.position.x - (camera.viewportWidth / 2) > tube.getTopPosition().x + tube.getTopTexture().getWidth()) {
                tube.reposition(tube.getTopPosition().x + (TUBE_SPACING + Tube.TUBE_WIDTH) * TUBE_COUNT);
            }
            if (tube.collides(bird.getBounds())) {
                gameStateManager.set(new PlayState(gameStateManager));
            }
        }
        camera.update();
    }

    @Override
    public void render(SpriteBatch spriteBatch) {
        spriteBatch.setProjectionMatrix(camera.combined);
        spriteBatch.begin();
        spriteBatch.draw(background, camera.position.x - (camera.viewportWidth / 2), 0);
        spriteBatch.draw(bird.getTexture(), bird.getPosition().x, bird.getPosition().y);
        for (Tube tube : listOfTubes) {
            spriteBatch.draw(tube.getTopTexture(), tube.getTopPosition().x, tube.getTopPosition().y);
            spriteBatch.draw(tube.getBottomTexture(), tube.getBottomPosition().x, tube.getBottomPosition().y);
        }
        spriteBatch.end();
    }

    @Override
    public void dispose() {

    }
}
