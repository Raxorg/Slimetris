package com.frontanilla.slimetris.logic;

import com.frontanilla.slimetris.newPieces.Piece;
import com.frontanilla.slimetris.newPieces.PiecePattern;
import com.frontanilla.slimetris.stuff.GameStuff;
import com.frontanilla.slimetris.stuff.Grid;

import static com.frontanilla.slimetris.logic.PieceMovementHandler.Movement.DOWN;

public class PieceMovementHandler {

    private GameLogic logic;
    private GameStuff stuff;
    // Logic
    private float time, downTimer, sideTimer;

    public enum Movement {
        RIGHT, LEFT, UP, DOWN;
    }

    public void update(float delta) {
        time += delta;
        downTimer += delta;
        sideTimer += delta;
        if (time >= 10f) {
            time = 0;
            movePieceDown(stuff.getCurrentPiece());
            logic.getCollisionHandler().pieceMoved(DOWN);
        }
    }

    public void movePieceRight() {
        if (sideTimer >= 0.04f) {
            sideTimer = 0f;
            PiecePattern[] patterns = stuff.getCurrentPiece().getPatterns();
            for (int i = 0; i < patterns.length; i++) {
                for (int j = 0; j < patterns[i].getSquares().length; j++) {
                    patterns[i].getSquares()[j].getBounds().x += Grid.CELL_SIZE;
                }
            }
        }
    }

    public void movePieceLeft() {
        if (sideTimer >= 0.04f) {
            sideTimer = 0f;
            PiecePattern[] patterns = stuff.getCurrentPiece().getPatterns();
            for (int i = 0; i < patterns.length; i++) {
                for (int j = 0; j < patterns[i].getSquares().length; j++) {
                    patterns[i].getSquares()[j].getBounds().x -= Grid.CELL_SIZE;
                }
            }
        }
    }

    public void movePieceUp() {
        Piece piece = stuff.getCurrentPiece();
        for (int i = 0; i < piece.getPatterns().length; i++) {
            for (int j = 0; j < piece.getPatterns()[i].getSquares().length; j++) {
                piece.getPatterns()[i].getSquares()[j].getBounds().y += Grid.CELL_SIZE;
            }
        }
    }

    public void movePieceDown() {
        if (downTimer >= 0.075f) {
            time = 0;
            downTimer = 0;
            movePieceDown(stuff.getCurrentPiece());
            logic.getCollisionHandler().pieceMoved(DOWN);
        }
    }

    public void rotatePieceRight() {
        Piece piece = stuff.getCurrentPiece();
        piece.setCurrentPattern(piece.getCurrentPattern().getNextPattern());
    }

    public void rotatePieceLeft() {
        Piece piece = stuff.getCurrentPiece();
        piece.setCurrentPattern(piece.getCurrentPattern().getPreviousPattern());
    }

    public void movePieceDown(Piece piece) {
        for (int i = 0; i < piece.getPatterns().length; i++) {
            for (int j = 0; j < piece.getPatterns()[i].getSquares().length; j++) {
                piece.getPatterns()[i].getSquares()[j].getBounds().y -= Grid.CELL_SIZE;
            }
        }
    }

    public void setLogic(GameLogic logic) {
        this.logic = logic;
    }

    public void setStuff(GameStuff stuff) {
        this.stuff = stuff;
    }
}