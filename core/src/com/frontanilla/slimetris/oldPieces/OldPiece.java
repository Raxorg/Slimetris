package com.frontanilla.slimetris.oldPieces;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.frontanilla.slimetris.newPieces.Square;
import com.frontanilla.slimetris.stuff.Grid;
import com.frontanilla.slimetris.stuff.PlatformerPlayer;

public abstract class OldPiece {

    protected Square[] squares;
    protected Color color, originalColor;
    protected int cellHeight;

    public void render(SpriteBatch batch) {
        batch.setColor(color);
        for (int i = 0; i < squares.length; i++) {
            squares[i].render(batch);
        }
    }

    public boolean collides(PlatformerPlayer player) {
        for (int i = 0; i < squares.length; i++) {
            if (squares[i].getBounds().overlaps(player.getBounds())) {
                return true;
            }
        }
        return false;
    }

    public boolean collides(OldPiece other) {
        for (int i = 0; i < squares.length; i++) {
            for (int j = 0; j < other.squares.length; j++) {
                if (squares[i].getBounds().overlaps(other.squares[j].getBounds())) {
                    return true;
                }
            }
        }
        return false;
    }

    public void moveToSpawn() {
        int halfX = Grid.COLUMNS / 2;
        int topY = Grid.ROWS - 1 - cellHeight;
        setPosition(halfX, topY);
    }

    protected abstract void setPosition(int column, int row);

    public int getY() {
        return (int) squares[0].getBounds().y;
    }

    public void setSquareRegion(TextureRegion squareRegion) {
        for (int i = 0; i < squares.length; i++) {
            squares[i].setRegion(squareRegion);
        }
    }

    public Square[] getSquares() {
        return squares;
    }

    public Color getOriginalColor() {
        return originalColor;
    }

    public Color getTransparentColor() {
        return originalColor.cpy().lerp(Color.CLEAR, 0.25f);
    }

    public void setColor(Color color) {
        this.color = color;
    }
}