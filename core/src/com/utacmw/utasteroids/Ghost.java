package com.utacmw.utasteroids;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.viewport.Viewport;

import java.util.Random;

/**
 * Class for the ghost
 * @author Ben
 */
public class Ghost {
    Player player;
    Sprite sprite;
    // Set the speed of the ghost
    float SPEED = 10.0f;
    Viewport viewport;
    Vector2 position;
    Vector2 direction;
    Rectangle bounds;
    private int index;

    public Ghost(Viewport viewport, Player player){
        this.player = player;
        sprite = new Sprite(new Texture("ghost.png"));
        this.viewport = viewport;
        // Create a random number generator
        Random random = new Random();
        sprite.setOriginCenter();
        sprite.setSize(25, 25);
        // TODO Make them appear outside of the screen
        // Set the position of the ghost
        sprite.setPosition(getRandomX(random), random.nextFloat() * 180);
        position = new Vector2();
        this.position.x = this.sprite.getX();
        this.position.y = this.sprite.getY();
        direction = new Vector2();
    }

    private float getRandomX(Random random){
        int number = random.nextInt(1);
        Gdx.app.log(this.getClass().getName(), "Number: " + number);
        switch (number){
            case 0:
                float randomNumber = random.nextFloat();
                Gdx.app.log("GHOST", "Random Number: " + randomNumber);
                float x = randomNumber + this.viewport.getScreenWidth() + this.sprite.getWidth();
                Gdx.app.log("GHOST", "X: " + x);
                return x;
            case 1:
                return random.nextFloat() - this.viewport.getScreenWidth() - this.sprite.getWidth();
        }
        return 0;
    }

    //TODO Create a hit box and create children from hit
    public boolean onCollision() {
        if (this.bounds.overlaps(player.getBounds()) && !player.isInvincible()) {
            System.out.println("Collision!");
            return true;
        }
        return false;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getIndex() { return this.index; }
    /**
     * This method moves the ghost towards the player
     * @param delta
     */
    private void move(float delta){
        direction.x = this.player.getPosition().x - this.sprite.getX();
        direction.y = this.player.getPosition().y - this.sprite.getY();

        double hypotenuse = Math.sqrt(direction.x * direction.x + direction.y * direction.y);
        direction.x /= hypotenuse;
        direction.y /= hypotenuse;

        this.position.x += direction.x * this.SPEED * delta;
        this.position.y += direction.y * this.SPEED * delta;
        this.sprite.setPosition(this.position.x, this.position.y);

    }

    /**
     * Updates the ghost once per frame
     * @param delta
     */
    public void update(float delta){
        bounds = sprite.getBoundingRectangle();
        // Move the ghost
        move(delta);
        if(onCollision()){
            player.respawn();
        }
    }

    public void draw(SpriteBatch batch){
        //Draw the ghost to the screen
        sprite.draw(batch);
    }
}
