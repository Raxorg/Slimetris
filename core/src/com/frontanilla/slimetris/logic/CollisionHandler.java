package com.frontanilla.slimetris.logic;

import com.badlogic.gdx.utils.DelayedRemovalArray;
import com.frontanilla.slimetris.logic.PieceMovementHandler.Movement;
import com.frontanilla.slimetris.newPieces.Piece;
import com.frontanilla.slimetris.newPieces.PiecePattern;
import com.frontanilla.slimetris.newPieces.Square;
import com.frontanilla.slimetris.stuff.GameStuff;

public class CollisionHandler {

    // Structure
    private GameLogic logic;
    private GameStuff stuff;

    public void pieceMoved(Movement movement) {
        Piece piece = stuff.getCurrentPiece();
        switch (movement) {
            case RIGHT:
                break;
            case LEFT:
                break;
            case UP:
                break;
            case DOWN:
                handleDownMovement(piece);
                break;
        }
    }

    private void handleDownMovement(Piece currentPiece) {
        PiecePattern currentPattern = currentPiece.getCurrentPattern();
        Square[] squares = currentPattern.getSquares();
        DelayedRemovalArray<Piece> pieces = stuff.getPieces();
        for (int i = 0; i < squares.length; i++) {
            // Bottom of play field
            if (squares[i].getBounds().y < 0) {
                logic.getPieceMovementHandler().movePieceUp();
                currentPiece.setColor(currentPiece.getColor().mul(2f));
                stuff.getPieces().add(currentPiece);
                logic.getPieceSpawnHandler().spawnNewPiece();
                return;
            }
            // Other pieces
            for (int j = 0; j < pieces.size; j++) {
                if (pieces.get(j).getCurrentPattern().overlaps(squares[i].getBounds())) {
                    logic.getPieceMovementHandler().movePieceUp();
                    currentPiece.setColor(currentPiece.getColor().mul(2f));
                    stuff.getPieces().add(currentPiece);
                    logic.getPieceSpawnHandler().spawnNewPiece();
                    return;
                }
            }
        }
    }

    public void pieceRotated() {

    }

    private void verifyCollisionsWithPlayers() {
        /* TODO
        if (stuff.getCurrentPiece().collides(stuff.getPlatformerPlayer1())) {
            stuff.getCurrentPiece().moveUp();
            stuff.getPieces().add(stuff.getCurrentPiece());
            appearPiece();
        }
         */
    }

    public void verifyCollisionsWithPieces() {
        /* TODO
        for (int i = 0; i < stuff.getPieces().size; i++) {
            if (stuff.getCurrentPiece().collides(stuff.getPieces().get(i))) {
                switch (stuff.getCurrentPiece().getLastMove()) {
                    case LEFT:
                        System.out.println("left collision");
                        stuff.getCurrentPiece().moveRight();
                        break;
                    case RIGHT:
                        System.out.println("right collision");
                        stuff.getCurrentPiece().moveLeft();
                        break;
                    case DOWN:
                        System.out.println("down collision");
                        stuff.getCurrentPiece().moveUp();
                        stuff.getCurrentPiece().setColor(stuff.getCurrentPiece().getOriginalColor());
                        stuff.getPieces().add(stuff.getCurrentPiece());
                        appearPiece();
                        break;
                }
            }
        }
         */
    }

    public void setLogic(GameLogic logic) {
        this.logic = logic;
    }

    public void setStuff(GameStuff stuff) {
        this.stuff = stuff;
    }
}