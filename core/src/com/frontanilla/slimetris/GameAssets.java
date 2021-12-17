package com.frontanilla.slimetris;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class GameAssets {

    private TextureRegion player, square;

    public GameAssets() {
        player = new TextureRegion(new Texture("slime.png"));
        square = new TextureRegion(new Texture("square3.png"));
    }

    public TextureRegion getPlayer() {
        return player;
    }

    public TextureRegion getSquare() {
        return square;
    }
}