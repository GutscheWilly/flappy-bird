package com.willy.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.willy.game.FlappyBird;

public class MenuState extends State {

    private Texture background;
    private Texture playButton;

    public MenuState(GameStateManager gameStateManager) {
        super(gameStateManager);
        background = new Texture("bg.png");
        playButton = new Texture("playbtn.png");
    }

    @Override
    public void handleInput() {
        if (Gdx.input.justTouched()) {
            gameStateManager.set(new PlayState(gameStateManager));
        }
    }

    @Override
    public void update(Float deltaTime) {
        handleInput();
    }

    @Override
    public void render(SpriteBatch spriteBatch) {
        spriteBatch.begin();
        spriteBatch.draw(background, 0, 0, FlappyBird.WIDTH, FlappyBird.HEIGTH);
        spriteBatch.draw(playButton, (FlappyBird.WIDTH / 2) - (playButton.getWidth() / 2), FlappyBird.HEIGTH / 2);
        spriteBatch.end();
    }

    @Override
    public void dispose() {
        background.dispose();
        playButton.dispose();
        System.out.println("Menu State disposed!");
    }
}
