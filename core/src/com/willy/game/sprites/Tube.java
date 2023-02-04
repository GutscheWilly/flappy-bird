package com.willy.game.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

import java.util.Random;

public class Tube {

    public static final int TUBE_WIDTH = 52;
    private static final int FLUCTUATION = 130;
    private static final int TUBE_GAP = 100;
    private static final int LOWEST_OPENING = 120;

    private Texture topTexture, bottomTexture;
    private Vector2 topPosition, bottomPosition;
    private Random rand;
    private Rectangle boundsTopRectangle, boundsBotRectangle;

    public Tube(float sourceX) {
        topTexture = new Texture("toptube.png");
        bottomTexture = new Texture("bottomtube.png");
        rand = new Random();
        topPosition = new Vector2(sourceX, rand.nextInt(FLUCTUATION) + TUBE_GAP + LOWEST_OPENING);
        bottomPosition = new Vector2(sourceX, topPosition.y - TUBE_GAP - bottomTexture.getHeight());
        boundsTopRectangle = new Rectangle(topPosition.x, topPosition.y, topTexture.getWidth(), topTexture.getHeight());
        boundsBotRectangle = new Rectangle(bottomPosition.x, bottomPosition.y, bottomTexture.getWidth(), bottomTexture.getHeight());
    }

    public Texture getBottomTexture() {
        return bottomTexture;
    }

    public Texture getTopTexture() {
        return topTexture;
    }

    public Vector2 getTopPosition() {
        return topPosition;
    }

    public Vector2 getBottomPosition() {
        return bottomPosition;
    }

    public void reposition(float x) {
        topPosition.set(x, rand.nextInt(FLUCTUATION) + TUBE_GAP + LOWEST_OPENING);
        bottomPosition.set(x, topPosition.y - TUBE_GAP - bottomTexture.getHeight());
        boundsTopRectangle.setPosition(topPosition.x, topPosition.y);
        boundsBotRectangle.setPosition(bottomPosition.x, bottomPosition.y);
    }

    public boolean collides(Rectangle player) {
        return player.overlaps(boundsTopRectangle) || player.overlaps(boundsBotRectangle);
    }
}
