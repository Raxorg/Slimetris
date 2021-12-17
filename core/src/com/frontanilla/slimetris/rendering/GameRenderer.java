package com.frontanilla.slimetris.rendering;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.frontanilla.slimetris.stuff.GameStuff;

public class GameRenderer {

    // Rendering
    private ShapeRenderer renderer;
    private SpriteBatch batch;
    // Stuff
    private GameStuff stuff;

    public GameRenderer() {
        renderer = new ShapeRenderer();
        renderer.setAutoShapeType(true);
        batch = new SpriteBatch();
    }

    public void render() {
        // Clear last frame
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        // Draw new frame
        renderer.begin();

        stuff.getGrid().render(renderer);

        renderer.end();

        batch.begin();

        stuff.getPlatformerPlayer1().render(batch);
        stuff.getCurrentPiece().render(batch);
        for (int i = 0; i < stuff.getPieces().size; i++) {
            stuff.getPieces().get(i).render(batch);
        }

        batch.end();

        renderer.begin();

        stuff.getCurrentPiece().renderDebug(renderer);

        renderer.end();
    }

    public void setStuff(GameStuff stuff) {
        this.stuff = stuff;
    }

    public void dispose() {
        batch.dispose();
        renderer.dispose();
    }
}