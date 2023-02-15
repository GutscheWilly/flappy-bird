package com.willy.game;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import com.willy.game.FlappyBird;

public class DesktopLauncher {
	public static void main (String[] arg) {
		Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
		config.setWindowedMode(FlappyBird.WIDTH, FlappyBird.HEIGTH);
		config.setTitle(FlappyBird.TITLE);
		config.setWindowIcon("bird.png");
		config.setForegroundFPS(60);
		new Lwjgl3Application(new FlappyBird(), config);
	}
}
