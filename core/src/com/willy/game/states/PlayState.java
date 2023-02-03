package com.willy.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.willy.game.FlappyBird;
import com.willy.game.sprites.Bird;
import com.willy.game.sprites.Tube;

public class PlayState extends State {

    private Bird bird;
    private Texture background;
    private Tube tube;

    public PlayState(GameStateManager gameStateManager) {
        super(gameStateManager);
        bird = new Bird(50, 300);
        background = new Texture("bg.png");
        tube = new Tube(100);
        camera.setToOrtho(false, FlappyBird.WIDTH / 2, FlappyBird.HEIGTH / 2);
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
    }

    @Override
    public void render(SpriteBatch spriteBatch) {
        spriteBatch.setProjectionMatrix(camera.combined);
        spriteBatch.begin();
        spriteBatch.draw(background, camera.position.x - (camera.viewportWidth / 2), 0);
        spriteBatch.draw(bird.getTexture(), bird.getPosition().x, bird.getPosition().y);
        spriteBatch.draw(tube.getTopTexture(), tube.getTopPosition().x, tube.getTopPosition().y);
        spriteBatch.draw(tube.getBottomTexture(), tube.getBottomPosition().x, tube.getBottomPosition().y);
        spriteBatch.end();
    }

    @Override
    public void dispose() {

    }
}
