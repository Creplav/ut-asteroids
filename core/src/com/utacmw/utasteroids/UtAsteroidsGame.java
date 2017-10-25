package com.utacmw.utasteroids;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;

public class UtAsteroidsGame extends Game {

	@Override
	public void create() {
		Gdx.app.setLogLevel(Application.LOG_INFO);
		// Set the main screen as the game screen
		//TODO Change this to the menu screen
		setScreen(new MenuScreen(this));

		//TODO Create a menu screen
	}
}
