package com.utacmw.utasteroids.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.utacmw.utasteroids.UtAsteroidsGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		// Set the application to be fullscreen as default
		config.fullscreen = true;
		config.title = "UT Asteroids";
		new LwjglApplication(new UtAsteroidsGame(), config);
	}
}
