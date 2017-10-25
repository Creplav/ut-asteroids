package com.utacmw.utasteroids;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

/**
 * Created by ben on 10/24/17.
 */

public class GameOverOverlay {
    Viewport viewport;
    BitmapFont font;

    public GameOverOverlay() {
        this.viewport = new ExtendViewport(200, 200);
        font = new BitmapFont();
        font.setColor(Color.WHITE);
        font.getData().setScale(1);
    }

    public void render(SpriteBatch batch){
        viewport.apply(true);
        batch.setProjectionMatrix(viewport.getCamera().combined);
        batch.begin();
        font.draw(batch, "GAME OVER", viewport.getScreenWidth() / 2, viewport.getScreenHeight() / 2);
        batch.end();
    }
}
