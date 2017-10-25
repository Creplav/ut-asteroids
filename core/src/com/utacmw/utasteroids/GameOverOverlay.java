package com.utacmw.utasteroids;

import com.badlogic.gdx.Gdx;
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
        this.viewport = new ExtendViewport(100, 100);
        generator = new FreeTypeFontGenerator(Gdx.files.internal("dangerflight.ttf"));
        FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.size = 10;
        parameter.color = Color.WHITE;
        font = generator.generateFont(parameter);
    }

    public void dispose() {
        font.dispose();
        generator.dispose();
    }

    public void render(SpriteBatch batch){
        viewport.apply();
        batch.setProjectionMatrix(viewport.getCamera().combined);
        batch.begin();
        font.draw(batch, "Your score is: ", viewport.getWorldWidth() / 2, viewport.getWorldHeight() - 10, 0, Align.center, false);
        font.draw(batch, "0000 ", viewport.getWorldWidth() / 2, viewport.getWorldHeight() - 20, 0, Align.center, false);
        font.draw(batch, "GAME OVER", viewport.getWorldWidth() / 2, viewport.getWorldHeight() / 2.5f, 0, Align.center, false);
        batch.end();
    }
}