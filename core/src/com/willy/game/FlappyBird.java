package com.willy.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.loaders.MusicLoader;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.willy.game.states.GameStateManager;
import com.willy.game.states.MenuState;

public class FlappyBird extends ApplicationAdapter {

	public static final int WIDTH = 480;
	public static final int HEIGTH = 700;
	public static final String TITLE = "Flappy Bird";

	private GameStateManager gameStateManager;
	private SpriteBatch batch;
	private Music music;
	
	@Override
	public void create () {
		gameStateManager = new GameStateManager();
		gameStateManager.push(new MenuState(gameStateManager));
		batch = new SpriteBatch();
		music = Gdx.audio.newMusic(Gdx.files.internal("music.mp3"));
		music.setLooping(true);
		music.setVolume(0.05f);
		music.play();
		ScreenUtils.clear(1, 0, 0, 1);
	}

	@Override
	public void render () {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		gameStateManager.update(Gdx.graphics.getDeltaTime());
		gameStateManager.render(batch);
	}
	
	@Override
	public void dispose () {
		super.dispose();
		batch.dispose();
		music.dispose();
	}
}
