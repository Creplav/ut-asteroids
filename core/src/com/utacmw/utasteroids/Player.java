package com.utacmw.utasteroids;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.DelayedRemovalArray;
import com.badlogic.gdx.utils.Timer;
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
    private final float MAX_SPEED = 1;
    private final float ACCELERATION = 0.7f;
    private final float TURN_SPEED = 200.0f;

    private Sprite sprite;
    private Vector2 position;
    private Viewport viewport;

    private Rectangle bounds;
    private Rectangle screenBounds;

    private float rotation;
    private boolean invincible;
    public boolean isDestroyed = false;

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
        //set viewport width and height
        viewport.setScreenHeight(200);
        viewport.setScreenWidth(200);
        // Center the player
        // X: ScreenWidth / 2 + SpriteSize / 2
        // Y: ScreenHeight / 2 - SpriteSize / 2
        sprite.setPosition( viewport.getScreenWidth() / 2 + this.sprite.getWidth() / 2,
                viewport.getScreenHeight() / 2 - this.sprite.getHeight() / 2);

        //Sets the player's position to the sprite's x and y value
        this.position.x = sprite.getX();
        this.position.y = sprite.getY();
        screenBounds = new Rectangle(0, 0, 100, 100);
    }

    public Rectangle getBounds() { return this.bounds; }

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

    public void updatePosition() {
        this.position.x = this.sprite.getX();
        this.position.y = this.sprite.getY();
    }

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
        if(speed < MAX_SPEED)
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
        // keep getRotation value less than 360
        if(this.sprite.getRotation() > 360 ){
            rotation =  this.sprite.getRotation() % 360;
        }else{
            rotation =  this.sprite.getRotation();
        }
        this.sprite.translateX(-speed * (float)Math.sin(Math.toRadians(rotation)));
        this.sprite.translateY(speed * (float)Math.cos(Math.toRadians(rotation)));
        wrap();
    }

    /**
     * Sets the player's position
     * @param position X and Y values for position
     */
    public void setPosition(Vector2 position){
        //TODO Decide if we need this
        this.sprite.setPosition(this.position.x = position.x , this.position.y = position.y);
    }

    private void invincibilityTimer(){
        invincible = true;
        Timer timer = new Timer();
        timer.delay(5000);
        invincible = false;
    }
    public boolean isInvincible() { return invincible; }
    public void respawn() {
        if(lives > 0){
            lives--;
            invincibilityTimer();
            sprite.setPosition( viewport.getScreenWidth() / 2 + this.sprite.getWidth() / 2,
                    viewport.getScreenHeight() / 2 - this.sprite.getHeight() / 2);
        }
        isDestroyed = true;
    }
    /**
     * Updates the player every frame
     * @param delta the frame rate of the game
     */
    public void update(float delta){
        bounds = sprite.getBoundingRectangle();
        updatePosition();
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
        if(Gdx.input.isKeyPressed(Input.Keys.SPACE)){
            shoot();
        }

        //TODO Add in the hardware values to control movement and shooting
    }
    /**
     * Draws the player to the screen
     * @param batch
     */
    public void draw(SpriteBatch batch) {
        // Draw a temp image in the center of the screen
        if(lives > 0)
            sprite.draw(batch);
    }

    public void wrap(){
        if(sprite.getX()> 200 + sprite.getHeight()){
            sprite.setX(0 - sprite.getHeight());
        }
        if(sprite.getX()< 0 - sprite.getHeight()){
            sprite.setX(200 + sprite.getHeight() - 1);
        }


        if(sprite.getY()> 200){
            sprite.setY(0 - sprite.getHeight());
        }
        if(sprite.getY()< 0 -sprite.getHeight()) {
            sprite.setY(200);
        }
    }
}
