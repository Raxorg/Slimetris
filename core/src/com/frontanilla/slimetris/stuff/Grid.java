package com.frontanilla.slimetris.stuff;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;

public class Grid {

    public static final int CELL_SIZE = 40;
    public static final int COLUMNS = Gdx.graphics.getWidth() / CELL_SIZE + 1;
    public static final int ROWS = Gdx.graphics.getHeight() / CELL_SIZE + 1;
    private Vector2[] horizontalPoints, verticalPoints;

    public Grid() {
        horizontalPoints = new Vector2[COLUMNS];
        verticalPoints = new Vector2[ROWS];
        for (int i = 0; i < COLUMNS; i++) {
            horizontalPoints[i] = new Vector2();
            horizontalPoints[i].set(i * CELL_SIZE, 0);
        }
        for (int i = 0; i < ROWS; i++) {
            verticalPoints[i] = new Vector2();
            verticalPoints[i].set(0, i * CELL_SIZE);
        }
    }

    public void render(ShapeRenderer renderer) {
        renderer.setColor(Color.GRAY);
        renderer.set(ShapeRenderer.ShapeType.Filled);
        for (int i = 0; i < horizontalPoints.length; i++) {
            renderer.rectLine(
                    horizontalPoints[i],
                    horizontalPoints[i].cpy().add(0, Gdx.graphics.getHeight()),
                    2);
        }
        for (int i = 0; i < verticalPoints.length; i++) {
            renderer.rectLine(
                    verticalPoints[i],
                    verticalPoints[i].cpy().add(Gdx.graphics.getWidth(), 0),
                    2);
        }
    }
}