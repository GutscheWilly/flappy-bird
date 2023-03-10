package com.willy.game.sprites;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;

public class Bird {

    private static final int GRAVITY = -15;
    private static final int MOVEMENT = 100;

    private Vector3 position;
    private Vector3 velocity;

    private Texture texture;
    private Animation animation;
    private Rectangle bounds;
    private Sound flap;

    public Bird(int sourceX, int sourceY) {
        position = new Vector3(sourceX, sourceY, 0);
        velocity = new Vector3(0, 0, 0);
        texture = new Texture("birdanimation.png");
        animation = new Animation(new TextureRegion(texture), 3, 0.5f);
        bounds = new Rectangle(position.x, position.y, texture.getWidth() / 3, texture.getHeight());
        flap = Gdx.audio.newSound(Gdx.files.internal("sfx_wing.ogg"));
    }

    public Vector3 getPosition() {
        return position;
    }

    public TextureRegion getTexture() {
        return animation.getFrame();
    }

    public Rectangle getBounds() {
        return bounds;
    }

    public void update(float deltaTime) {
        animation.update(deltaTime);
        if (position.y > 0) {
            velocity.add(0, GRAVITY, 0);
        }
        velocity.scl(deltaTime);
        position.add(MOVEMENT * deltaTime, velocity.y, 0);
        if (position.y < 0) {
            position.y = 0;
        }
        velocity.scl(1 / deltaTime);
        bounds.setPosition(position.x, position.y);
    }

    public void jump() {
        velocity.y = 250;
        flap.play(0.5f);
    }

    public void dispose() {
        texture.dispose();
        flap.dispose();
    }
}
