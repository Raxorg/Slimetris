package com.frontanilla.slimetris.logic;

import com.frontanilla.slimetris.GameAssets;
import com.frontanilla.slimetris.newPieces.Piece;
import com.frontanilla.slimetris.newPieces.PiecePattern;
import com.frontanilla.slimetris.newPieces.Square;
import com.frontanilla.slimetris.stuff.GameStuff;
import com.frontanilla.slimetris.stuff.Grid;
import com.frontanilla.slimetris.util.RandomUtils;

public class PieceSpawnHandler {

    private GameAssets assets;
    private GameStuff stuff;

    public void init() {
        spawnNewPiece();
    }

    public void spawnNewPiece() {
        Piece newPiece = RandomUtils.randomPiece();
        newPiece.setSquareImage(assets.getSquare());
        PiecePattern[] piecePatterns = newPiece.getPatterns();
        for (int i = 0; i < piecePatterns.length; i++) {
            Square[] squares = piecePatterns[i].getSquares();
            for (int j = 0; j < squares.length; j++) {
                squares[j].getBounds().x += (Grid.COLUMNS / 2) * Grid.CELL_SIZE;
                squares[j].getBounds().y += Grid.ROWS * Grid.CELL_SIZE;
                switch (newPiece.getType()) {
                    case I:
                        squares[j].getBounds().y -= Grid.CELL_SIZE * 4;
                        break;
                    case J:
                        squares[j].getBounds().y -= Grid.CELL_SIZE * 4;
                        break;
                    case L:
                        squares[j].getBounds().y -= Grid.CELL_SIZE * 4;
                        break;
                    case O:
                        squares[j].getBounds().y -= Grid.CELL_SIZE * 3;
                        break;
                    case S:
                        squares[j].getBounds().y -= Grid.CELL_SIZE * 4;
                        break;
                    case T:
                        squares[j].getBounds().y -= Grid.CELL_SIZE * 4;
                        break;
                    case Z:
                        squares[j].getBounds().y -= Grid.CELL_SIZE * 4;
                        break;
                }
            }
        }
        newPiece.setColor(newPiece.getColor().cpy().mul(0.5f));
        stuff.setCurrentPiece(newPiece);
    }

    public void setAssets(GameAssets assets) {
        this.assets = assets;
    }

    public void setStuff(GameStuff stuff) {
        this.stuff = stuff;
    }
}