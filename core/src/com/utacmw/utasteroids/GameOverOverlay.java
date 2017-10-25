package com.utacmw.utasteroids;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.*;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.Viewport;


/**
 * Game over overlay
 * @author Ben
 */

public class GameOverOverlay {
    public final Viewport viewport;
    BitmapFont font;
    FreeTypeFontGenerator generator;


    public GameOverOverlay() {
        this.viewport = new ExtendViewport(500, 500);
        generator = new FreeTypeFontGenerator(Gdx.files.internal("dangerflight.ttf"));
        FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.size = 50;
        parameter.color = Color.WHITE;
        font = generator.generateFont(parameter);
    }

    public void dispose() {
        font.dispose();
        generator.dispose();
    }

    public void render(SpriteBatch batch, int score, Game game, GameScreen gameScreen){
        viewport.apply();
        batch.setProjectionMatrix(viewport.getCamera().combined);
        batch.begin();
        font.draw(batch, "Your score is: ", viewport.getWorldWidth() / 2, viewport.getWorldHeight() - 20, 0, Align.center, false);
        font.draw(batch, "" + score, viewport.getWorldWidth() / 2, viewport.getWorldHeight() - 80, 0, Align.center, false);
        font.draw(batch, "GAME OVER", viewport.getWorldWidth() / 2, viewport.getWorldHeight() / 2, 0, Align.center, false);
        font.draw(batch, "SPACE: Return to menu", viewport.getWorldWidth() / 2, viewport.getWorldHeight() / 3.5f, 0, Align.center, false);
        batch.end();
        if(Gdx.input.isKeyJustPressed(Input.Keys.SPACE)){
            game.setScreen(new MenuScreen(game, gameScreen));
        }
    }
}