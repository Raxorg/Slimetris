package com.frontanilla.slimetris.input;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.frontanilla.slimetris.logic.GameLogic;

public class GameInput extends InputAdapter {

    private GameLogic logic;

    public void checkKeyboard() {
        // Tetris Player
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            logic.getInputHandler().rightPressed();
        }
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            logic.getInputHandler().leftPressed();
        }
        if (Gdx.input.isKeyJustPressed(Input.Keys.UP)) {
            logic.getInputHandler().upPressed();
        }
        if (Gdx.input.isKeyJustPressed(Input.Keys.Z)) {
            logic.getInputHandler().zPressed();
        }
        if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
            logic.getInputHandler().downPressed();
        }
        // Platformer Player
        if (Gdx.input.isKeyPressed(Input.Keys.W)) {
            logic.getPlatformerPlayerHandler().wPressed();
        }
        if (Gdx.input.isKeyPressed(Input.Keys.D)) {
            logic.getPlatformerPlayerHandler().dPressed();
        }
        if (Gdx.input.isKeyPressed(Input.Keys.A)) {
            logic.getPlatformerPlayerHandler().aPressed();
        }
    }

    public void setLogic(GameLogic logic) {
        this.logic = logic;
    }
}