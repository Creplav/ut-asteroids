package com.utacmw.utasteroids;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.Random;

/**
 * Created by ben on 10/21/17.
 */
public class Ghost {
    Player player;
    Sprite sprite;
    // Set the speed of the ghost
    float SPEED = 3.0f;

    public Ghost(Player player){
        this.player = player;
        sprite = new Sprite(new Texture("ghost.png"));
        // Create a random number generator
        Random random = new Random();
        sprite.setOriginCenter();
        sprite.setSize(25, 25);
        // TODO Make them appear outside of the screen
        // Set the position of the ghost
        sprite.setPosition(random.nextFloat() * 180, random.nextFloat() * 180);
    }

    //TODO Create a hit box and create children from hit

    /**
     * This method moves the ghost
     * @param delta
     */
    private void move(float delta){
        //TODO Move toward the player
        // Moves the ghost
        this.sprite.translate(this.SPEED * delta, this.SPEED * delta);
    }

    /**
     * Updates the ghost once per frame
     * @param delta
     */
    public void update(float delta){
        // Move the ghost
        move(delta);
    }

    public void draw(SpriteBatch batch){
        //Draw the ghost to the screen
        sprite.draw(batch);
    }
}
