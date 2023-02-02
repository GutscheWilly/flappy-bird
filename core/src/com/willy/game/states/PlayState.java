package com.willy.game.states;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.willy.game.FlappyBird;

public class PlayState extends State {

    private Texture bird;

    public PlayState(GameStateManager gameStateManager) {
        super(gameStateManager);
        bird = new Texture("bird.png");
        camera.setToOrtho(false, FlappyBird.WIDTH / 2, FlappyBird.HEIGTH / 2);
    }

    @Override
    public void handleInput() {

    }

    @Override
    public void update(Float deltaTime) {

    }

    @Override
    public void render(SpriteBatch spriteBatch) {
        spriteBatch.setProjectionMatrix(camera.combined);
        spriteBatch.begin();
        spriteBatch.draw(bird, 50, 50);
        spriteBatch.end();
    }

    @Override
    public void dispose() {

    }
}
