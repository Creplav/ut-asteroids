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

    private final float speed = 200;

    private Sprite sprite;
    private Vector2 position;
    private Player player;
    private Texture text;



    public Bullet(Viewport viewport, Player player){
        this.player = player;
        sprite = new Sprite(new Texture("fireball.png"));
        this.viewport = viewport;





        sprite.setSize(10, 10);
        lifeTime = 1;
        lifeTimer = 0;

        position = new Vector2();
        this.position.x = this.sprite.getX();
        this.position.y = this.sprite.getY();


        position.x = this.player.getPosition().x + this.player.getHeight()/2- this.sprite.getWidth()/2;
        position.y = this.player.getPosition().y + this.player.getWidth()/2 - this.sprite.getWidth()/2;

    }


    private void move(float delta){


        position.x += -speed * delta * (float)Math.sin(Math.toRadians(player.getRotation()));
        position.y += speed * delta * (float)Math.cos(Math.toRadians(player.getRotation()));
        this.sprite.setPosition(this.position.x, this.position.y);

    }


    public boolean shouldRemove(){ return remove; }



    public void update(float delta){
        move(delta);

        lifeTimer += delta;
        if (lifeTimer > lifeTime){
            remove = true;
        }
    }



    public void draw(SpriteBatch batch){
        sprite.draw(batch);
    }







}
