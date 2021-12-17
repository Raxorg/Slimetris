package com.frontanilla.slimetris.rendering;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;

public class DrawUtils {

    public static void draw(SpriteBatch batch, TextureRegion region, Rectangle bounds) {
        batch.draw(region, bounds.x, bounds.y, bounds.width, bounds.height);
    }
}