package com.utacmw.utasteroids;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.DelayedRemovalArray;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import java.util.ArrayList;

/**
 * Controls the screen for the game
 * @author Ben
 */
public class GameScreen extends ScreenAdapter {

    SpriteBatch batch;
    Viewport viewport;
    Player player;
    Ghost ghost;
    Texture background;
    Bullet bullet;

    Array<Ghost> ghosts;
    Array<Player> players;
    private ArrayList<Bullet> bullets;
    private final int MAX_BULLETS = 4;



    GameOverOverlay gameOverOverlay;

    @Override
    public void show() {
        // Set up the necessary objects
        batch = new SpriteBatch();
        // Create the viewport
        viewport = new ExtendViewport(200,200);
        // Create the player
        players = new DelayedRemovalArray<Player>();
        player = new Player(viewport,bullets);
        players.add(player);
        //
        bullet = new Bullet(viewport,player);
        //
        ghost = new Ghost(viewport, player);
        // Create the texture for the background
        background = new Texture("background.png");
        viewport.setScreenHeight(200);
        viewport.setScreenWidth(200);
        ghosts = new Array<Ghost>();
        bullets = new ArrayList<Bullet>();

        addGhosts(false);
        gameOverOverlay = new GameOverOverlay();

    }
    private void shoot(){
        //TODO Set up the shooting
        if (bullets.size() == MAX_BULLETS) return;
        bullets.add(new Bullet(viewport,player));

    }

    public void addGhosts(boolean timer){
        for(int i = 0; i < 5; i++){
            Ghost ghost = new Ghost(viewport, player);
            ghost.setIndex(i);
            ghosts.add(ghost);
        }
    }


    @Override
    public void resize(int width, int height) {
        viewport.update(width, height, true);
    }

    @Override
    public void dispose() {
    }

    @Override
    public void render(float delta) {
        // Apply the viewport
        viewport.apply();
        // Some OpenGL stuff. It needs to be there so don't touch this for now
        Gdx.gl.glClearColor(Color.rgb565(Color.RED), 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        player.update(delta);
        for (Ghost ghost: ghosts) {
            ghost.update(delta);
            if(ghost.onCollision())
                ghosts.removeValue(ghost, true);
        }
        if(player.getLives() <= 0){
            gameOverOverlay.render(batch);
        }
        for(int i = 0; i < bullets.size();i++){
            bullets.get(i).update(delta);
            if(bullets.get(i).shouldRemove()){
                bullets.remove(i);
                i--;
            }
        }


        // Set the projection matrix
        batch.setProjectionMatrix(viewport.getCamera().combined);
        // Start the batch
        batch.begin();
        // TODO Fix resize issue where the background does not change with the size of the screen
        // Draw the background
        batch.draw(background, 0, 0, viewport.getScreenWidth() / 2, viewport.getScreenHeight() / 2);
        // Draw the player
        player.draw(batch);
        for (Ghost ghost : ghosts){
            ghost.draw(batch);
        }

        for(int i = 0; i<bullets.size();i++){
            bullets.get(i).draw(batch);
        }


        batch.end();

        if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE)){
            shoot();
        }







    }



}
