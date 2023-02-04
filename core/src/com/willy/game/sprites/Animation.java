package com.willy.game.sprites;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;

public class Animation {

    private Array<TextureRegion> frames;
    private float maxFrameTime;
    private float currentFrameTime;
    private int frameCount;
    private int frame;

    public Animation(TextureRegion textureRegion, int frameCount, float cycleTime) {
        frames = createFrames(textureRegion, frameCount);
        maxFrameTime = cycleTime / frameCount;
        currentFrameTime = 0;
        this.frameCount = frameCount;
        frame = 0;
    }

    private Array<TextureRegion> createFrames(TextureRegion textureRegion, int frameCount) {
        Array<TextureRegion> frames = new Array<>();
        int frameWidth = textureRegion.getRegionWidth() / frameCount;
        for (int i = 0 ; i < frameCount ; i++) {
            frames.add(new TextureRegion(textureRegion, i * frameWidth, 0, frameWidth, textureRegion.getRegionHeight()));
        }
        return frames;
    }

    public void update(float deltaTime) {
        currentFrameTime += deltaTime;
        if (currentFrameTime > maxFrameTime) {
            frame++;
            currentFrameTime = 0;
        }
        if (frame >= frameCount) {
            frame = 0;
        }
    }

    public TextureRegion getFrame() {
        return frames.get(frame);
    }
}
