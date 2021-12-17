package com.frontanilla.slimetris.stuff;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.frontanilla.slimetris.rendering.DrawUtils;

public class PlatformerPlayer {

    private TextureRegion region;
    private Rectangle bounds;
    private Color color;

    public PlatformerPlayer(TextureRegion region) {
        this.region = region;
        bounds = new Rectangle(0, 0, region.getRegionWidth() * 3, region.getRegionHeight() * 3);
        color = Color.GREEN;
    }

    public void render(SpriteBatch batch) {
        batch.setColor(color);
        DrawUtils.draw(batch, region, bounds);
    }

    public Rectangle getBounds() {
        return bounds;
    }

    public Rectangle getDownBounds() {
        Rectangle downBounds = new Rectangle(bounds);
        downBounds.y -= 5;
        return downBounds;
    }
}