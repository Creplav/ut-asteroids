package com.utacmw.utasteroids;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

/**
 * Created by ben on 10/25/17.
 */

public class HUD {
    public final Viewport viewport;
    BitmapFont font;
    FreeTypeFontGenerator generator;


    public HUD() {
        this.viewport = new ExtendViewport(500, 500);
        generator = new FreeTypeFontGenerator(Gdx.files.internal("dangerflight.ttf"));
        FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.size = 24;
        parameter.color = Color.WHITE;
        font = generator.generateFont(parameter);
    }

    public void dispose() {
        font.dispose();
        generator.dispose();
    }

    public void render(SpriteBatch batch, int score, int lives){
        viewport.apply();
        batch.setProjectionMatrix(viewport.getCamera().combined);
        batch.begin();
        font.draw(batch, "Score:  " + score, 0, viewport.getWorldHeight() - 20, 0, Align.left, false);
        font.draw(batch, "Lives:  " + lives, 0, viewport.getWorldHeight() - 50, 0, Align.left, false);
        batch.end();
    }
}
