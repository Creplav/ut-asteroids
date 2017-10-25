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
<<<<<<< HEAD
        this.viewport = new ExtendViewport(200, 200);
        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("dangerflight.ttf"));
=======
        this.viewport = new ExtendViewport(100, 100);
        generator = new FreeTypeFontGenerator(Gdx.files.internal("dangerflight.ttf"));
>>>>>>> a0711ddf8b72e48ddd0594b36bd2afc0201ae04a
        FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.size = 24;
        parameter.color = Color.WHITE;
        font = generator.generateFont(parameter);
<<<<<<< HEAD
=======
    }

    public void dispose() {
        font.dispose();
>>>>>>> a0711ddf8b72e48ddd0594b36bd2afc0201ae04a
        generator.dispose();
    }

    public void dispose() {
        font.dispose();
    }
    public void render(SpriteBatch batch){
        viewport.apply();
        batch.setProjectionMatrix(viewport.getCamera().combined);
        batch.begin();
<<<<<<< HEAD
        font.draw(batch, "GAME OVER", viewport.getScreenWidth() / 2, viewport.getScreenHeight() / 2, 0, Align.center, false);
=======
        font.draw(batch, "GAME OVER", viewport.getWorldWidth() / 2, viewport.getWorldHeight() / 2.5f, 0, Align.center, false);
>>>>>>> a0711ddf8b72e48ddd0594b36bd2afc0201ae04a
        batch.end();
    }
}
