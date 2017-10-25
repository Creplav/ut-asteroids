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
    Viewport viewport;
    BitmapFont font;

    public GameOverOverlay() {
        this.viewport = new ExtendViewport(200, 200);
        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("dangerflight.ttf"));
        FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.size = 24;
        parameter.color = Color.WHITE;
        font = generator.generateFont(parameter);
        generator.dispose();
    }

    public void dispose() {
        font.dispose();
    }
    public void render(SpriteBatch batch){
        viewport.apply(true);
        batch.setProjectionMatrix(viewport.getCamera().combined);
        batch.begin();
        font.draw(batch, "GAME OVER", viewport.getScreenWidth() / 2, viewport.getScreenHeight() / 2, 0, Align.center, false);
        batch.end();
    }
}
