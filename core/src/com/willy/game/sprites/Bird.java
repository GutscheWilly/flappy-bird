package com.willy.game.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector3;

public class Bird {

    private static final int GRAVITY = -150;

    private Vector3 position;
    private Vector3 velocity;

    private Texture texture;

    public Bird(int sourceX, int sourceY) {
        position = new Vector3(sourceX, sourceY, 0);
        velocity = new Vector3(0, 0, 0);
        texture = new Texture("bird.png");
    }

    public Vector3 getPosition() {
        return position;
    }

    public Texture getTexture() {
        return texture;
    }

    public void update(float deltaTime) {
        velocity.set(0, GRAVITY, 0);
        velocity.scl(deltaTime);
        position.add(0, velocity.y, 0);
        velocity.scl(1 / deltaTime);
    }
}
