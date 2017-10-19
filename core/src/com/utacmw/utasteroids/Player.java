package com.utacmw.utasteroids;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.viewport.Viewport;


/**
 * Class for the player
 * @author Ben
 */
public class Player {

    private int lives;
    private final float MIN_SPEED = 0;
    private float speed;
    private final float MAX_SPEED = 6;
    private final float ACCELERATION = 0.3f;

    private Vector2 position = new Vector2();

    /**
     * Creates a new player
     * @param viewport
     */
    public Player(Viewport viewport){
        // Set starting lives to 3
        lives = 3;
        // Set initial speed to 0
        speed = 0;
        this.position.x = viewport.getScreenWidth() / 2;
        this.position.y = viewport.getScreenHeight() / 2;
    }

    /**
     * Get the number of lives that the player has
     * @return
     */
    public int getLives() {
        return lives;
    }

    /**
     * Draws the player to the screen
     * @param batch
     */
    public void draw(SpriteBatch batch) {
        // Draw a temp image in the center of the screen
        batch.draw(new Texture("badlogic.jpg"), position.x - 50, position.y - 50, 100, 100);
    }
}
