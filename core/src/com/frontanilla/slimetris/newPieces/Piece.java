package com.frontanilla.slimetris.newPieces;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public abstract class Piece {

    protected PiecePattern[] patterns = new PiecePattern[4];
    protected PiecePattern currentPattern;
    protected Color color = Color.WHITE;
    protected PieceType type;

    public enum PieceType {
        I, J, L, O, S, T, Z
    }

    public void setSquareImage(TextureRegion region) {
        for (int i = 0; i < patterns.length; i++) {
            for (int j = 0; j < patterns[i].getSquares().length; j++) {
                patterns[i].getSquares()[j].setRegion(region);
            }
        }
    }

    public void render(SpriteBatch batch) {
        batch.setColor(color);
        for (int i = 0; i < currentPattern.getSquares().length; i++) {
            currentPattern.getSquares()[i].render(batch);
        }
    }

    public void renderDebug(ShapeRenderer renderer) {
        renderer.setColor(Color.TAN);
        for (int i = 0; i < currentPattern.getSquares().length; i++) {
            currentPattern.getSquares()[i].renderDebug(renderer);
        }
    }

    public PiecePattern[] getPatterns() {
        return patterns;
    }

    public PiecePattern getCurrentPattern() {
        return currentPattern;
    }

    public void setCurrentPattern(PiecePattern currentPattern) {
        this.currentPattern = currentPattern;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public PieceType getType() {
        return type;
    }
}