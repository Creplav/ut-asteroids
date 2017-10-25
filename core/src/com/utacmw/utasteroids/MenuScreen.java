package com.utacmw.utasteroids;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

/**
 * Created by ben on 10/25/17.
 */

public class MenuScreen extends ScreenAdapter {

    private final Game game;
    Viewport viewport;
    BitmapFont font;
    FreeTypeFontGenerator generator;
    SpriteBatch batch;

    GameScreen gameScreen;

    public MenuScreen(Game game){
        this.game = game;
    }

    public MenuScreen(Game game,  GameScreen gameScreen){
        this.game = game;
        this.gameScreen = gameScreen;
    }
    @Override
    public void show() {
        viewport = new ExtendViewport(700, 700);
        batch = new SpriteBatch();
        generator = new FreeTypeFontGenerator(Gdx.files.internal("dangerflight.ttf"));
        FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.size = 50;
        parameter.color = Color.WHITE;
        font = generator.generateFont(parameter);
    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height, true);
    }

    @Override
    public void dispose() {
        batch.dispose();
        gameScreen.dispose();
    }

    @Override
    public void render(float delta) {

        Gdx.gl20.glClear(GL20.GL_COLOR_BUFFER_BIT);
        Gdx.gl.glClearColor(0, 0, 0, 1);
        viewport.apply();
        batch.setProjectionMatrix(viewport.getCamera().combined);
        batch.begin();
        font.draw(batch, "Welcome to ACM-W's Asteroids!", viewport.getWorldWidth() / 2, viewport.getWorldHeight() - 10, 0, Align.center, false);
        font.draw(batch, "Press SPACE to play!", viewport.getWorldWidth() / 2, viewport.getWorldHeight() / 2.5f, 0, Align.center, false);
        batch.end();
        if(Gdx.input.isKeyJustPressed(Input.Keys.SPACE)) {
            game.setScreen(new GameScreen(game));
        }
    }
}
