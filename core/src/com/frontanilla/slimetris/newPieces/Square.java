package com.frontanilla.slimetris.newPieces;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.frontanilla.slimetris.rendering.DrawUtils;
import com.frontanilla.slimetris.stuff.Grid;

public class Square {

    private TextureRegion region;
    private Rectangle bounds;

    public Square() {
        bounds = new Rectangle(0, 0, Grid.CELL_SIZE, Grid.CELL_SIZE);
    }

    public void render(SpriteBatch batch) {
        DrawUtils.draw(batch, region, bounds);
    }

    public void renderDebug(ShapeRenderer renderer) {
        renderer.rect(bounds.x, bounds.y, bounds.width, bounds.height);
    }

    public void setRegion(TextureRegion region) {
        this.region = region;
    }

    public int getTop() {
        return (int) (bounds.y + bounds.height);
    }

    public Rectangle getBounds() {
        return bounds;
    }
}