package com.frontanilla.slimetris.newPieces;

import com.badlogic.gdx.math.Rectangle;
import com.frontanilla.slimetris.stuff.Grid;

public class PiecePattern {

    private Square[] squares;
    private PiecePattern nextPattern, previousPattern;

    public PiecePattern() {
        squares = new Square[4];
    }

    public Square[] getSquares() {
        return squares;
    }

    public void addSquare(int index, int x, int y) {
        Square newSquare = new Square();
        newSquare.getBounds().x = x * Grid.CELL_SIZE;
        newSquare.getBounds().y = y * Grid.CELL_SIZE;
        squares[index] = newSquare;
    }

    public boolean overlaps(Rectangle rectangle) {
        for (int i = 0; i < squares.length; i++) {
            if (squares[i].getBounds().overlaps(rectangle)) {
                return true;
            }
        }
        return false;
    }

    public PiecePattern getNextPattern() {
        return nextPattern;
    }

    public void setNextPattern(PiecePattern nextPattern) {
        this.nextPattern = nextPattern;
    }

    public PiecePattern getPreviousPattern() {
        return previousPattern;
    }

    public void setPreviousPattern(PiecePattern previousPattern) {
        this.previousPattern = previousPattern;
    }
}