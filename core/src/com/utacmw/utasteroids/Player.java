package com.utacmw.utasteroids;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.viewport.Viewport;

/**
 * Class for the player
 * @author Ben
 */
public class Player {
    // Variables for the player
    private int lives;
    private final float MIN_SPEED = 0;
    private float speed;
    private final float MAX_SPEED = 3;
    private final float ACCELERATION = 0.3f;
    private final float TURN_SPEED = 100.0f;

    private Sprite sprite;
    private Vector2 position;
    private Viewport viewport;

    /**
     * Creates a new player
     * @param viewport
     */
    public Player(Viewport viewport){
        // Set starting lives to 3
        lives = 3;
        // Set initial speed to 0
        speed = 0;
        // Set the viewport
        this.viewport = viewport;
        // Set up a 2D vector for the position
        position = new Vector2();
        // Create the sprite for the player
        //TODO Replace the sprite
        sprite = new Sprite(new Texture("rocket.png"));
        // Set the player's size to 50 by 50
        //TODO Change the values of the size based on what we decide later
        sprite.setSize(50, 50);
        // Set the origin to the center
        sprite.setOriginCenter();
        // Center the player
        sprite.setPosition(this.position.x - sprite.getWidth() / 2,
                this.position.y - sprite.getHeight() / 2);

        //Sets the player's position to the sprite's x and y value
        this.position.x = sprite.getX();
        this.position.y = sprite.getY();
    }

    /**
     * Get the number of lives that the player has
     * @return
     */
    public int getLives() {
        return lives;
    }

    /**
     * Gets the player's current position
     * @return current position
     */
    public Vector2 getPosition() {return this.position; }

    /**
     * Turns the player in the direction specified
     * @param degrees the number of degrees to turn
     */
    public void turn(float degrees){
        this.sprite.rotate(degrees);
    }

    /**
     * Accelerates the player until the max speed is reached
     */
    public void accelerate(){
        if(speed != MAX_SPEED)
            speed += ACCELERATION;
        else
            speed = MAX_SPEED;
    }

    /**
     * Decelerates the player
     */
    public void decelerate(){
        if(speed > MIN_SPEED)
            speed -= ACCELERATION;
        else
            speed = MIN_SPEED;
    }

    private void shoot(){
        //TODO Set up the shooting
    }

    /**
     * Moves the player in the direction it is facing
     */
    public void move(){
        //TODO Fix this because the math is bad somewhere
        this.sprite.translateX(speed * MathUtils.cos(this.sprite.getRotation()));
        this.sprite.translateY(speed * MathUtils.sin(this.sprite.getRotation()));
    }

    /**
     * Sets the player's position
     * @param position X and Y values for position
     */
    public void setPosition(Vector2 position){
        //TODO Decide if we need this
        this.sprite.setPosition(this.position.x = position.x, this.position.y = position.y);
    }

    /**
     * Updates the player every frame
     * @param delta the frame rate of the game
     */
    public void update(float delta){
       //TODO Check to see if the player is outside of the screen and if so wrap back around
        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
            turn(-TURN_SPEED * delta);
        }
        if(Gdx.input.isKeyPressed(Input.Keys.LEFT)){
            turn(TURN_SPEED * delta);
        }
        if(Gdx.input.isKeyPressed(Input.Keys.UP)){
            accelerate();
            move();
        }
        else decelerate();

        //TODO Add in the hardware values to control movement and shooting
    }
    /**
     * Draws the player to the screen
     * @param batch
     */
    public void draw(SpriteBatch batch) {
        // Draw a temp image in the center of the screen
        sprite.draw(batch);
    }
}
