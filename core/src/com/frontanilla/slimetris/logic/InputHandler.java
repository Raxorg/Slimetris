package com.frontanilla.slimetris.logic;

import com.frontanilla.slimetris.input.GameInput;

public class InputHandler {

    private GameInput input;
    private GameLogic logic;

    public void rightPressed() {
        logic.getPieceMovementHandler().movePieceRight();
    }

    public void leftPressed() {
        logic.getPieceMovementHandler().movePieceLeft();
    }

    public void upPressed() {
        logic.getPieceMovementHandler().rotatePieceRight();
    }

    public void zPressed() {
        logic.getPieceMovementHandler().rotatePieceLeft();
    }

    public void downPressed() {
        logic.getPieceMovementHandler().movePieceDown();
    }

    public void update() {
        input.checkKeyboard();
    }

    public void setInput(GameInput input) {
        this.input = input;
    }

    public void setLogic(GameLogic logic) {
        this.logic = logic;
    }
}