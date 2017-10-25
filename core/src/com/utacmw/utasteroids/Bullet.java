package com.utacmw.utasteroids;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.viewport.Viewport;




/**
 * Created by yizhenshi on 10/24/17.
 */

public class Bullet {

    //variables for the bullet
    private float lifeTime;
    private float lifeTimer;

    Viewport viewport;

    Rectangle hitbox;
    private boolean remove;

    private final float speed = 350;

    private Sprite sprite;
    private Vector2 position;
    private Player player;
    private Texture text;
    private float rotation;

    private Rectangle bounds;


    public Bullet(Viewport viewport, Player player){
        this.player = player;
        sprite = new Sprite(new Texture("fireball.png"));
        this.viewport = viewport;

        //TODO change the size of fireball
        sprite.setSize(5, 5);
        lifeTime = 1;
        lifeTimer = 0;

        position = new Vector2();
        this.position.x = this.sprite.getX();
        this.position.y = this.sprite.getY();

        if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE)){
            setRotation(player.getRotation());
        }

        position.x = this.player.getPosition().x + this.player.getHeight()/2- this.sprite.getWidth()/2;
        position.y = this.player.getPosition().y + this.player.getWidth()/2 - this.sprite.getWidth()/2;

        hitbox = this.sprite.getBoundingRectangle();




    }



    private void move(float delta){
            position.x += -speed * delta * (float) Math.sin(Math.toRadians(getRotation()));
            position.y += speed * delta * (float) Math.cos(Math.toRadians(getRotation()));
            this.sprite.setPosition(position.x, position.y);

    }


    public boolean shouldRemove(){ return remove; }



    public void update(float delta){
        if(sprite.getBoundingRectangle() != null){
            bounds = sprite.getBoundingRectangle();
        }else if(sprite.getBoundingRectangle() == null)
        {
            bounds = new Rectangle (0,0,5,5);
        }

        move(delta);

        lifeTimer += delta;
        if (lifeTimer > lifeTime){
            remove = true;
        }
        System.out.print(getBounds());
        System.out.print("\n");





    }



    public void draw(SpriteBatch batch){
        sprite.draw(batch);
    }

    public float setRotation( float x){
        rotation = x;
        return x;
    }
    public float getRotation(){
        return rotation;
    }
    public Rectangle getBounds() { return bounds; }











}
