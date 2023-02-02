package com.willy.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.willy.game.FlappyBird;
import com.willy.game.sprites.Bird;

public class PlayState extends State {

    private Bird bird;

    public PlayState(GameStateManager gameStateManager) {
        super(gameStateManager);
        bird = new Bird(50, 300);
        camera.setToOrtho(false, FlappyBird.WIDTH / 2, FlappyBird.HEIGTH / 2);
    }

    @Override
    public void handleInput() {

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
        spriteBatch.draw(bird.getTexture(), bird.getPosition().x, bird.getPosition().y);
        spriteBatch.end();
    }

    @Override
    public void dispose() {

    }
}
