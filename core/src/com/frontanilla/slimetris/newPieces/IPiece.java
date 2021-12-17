package com.frontanilla.slimetris.newPieces;

import com.badlogic.gdx.graphics.Color;

public class IPiece extends Piece {

    public IPiece() {
        patterns[0] = new PiecePattern();
        patterns[1] = new PiecePattern();
        patterns[2] = new PiecePattern();
        patterns[3] = new PiecePattern();

        patterns[0].addSquare(0, 0, 2);
        patterns[0].addSquare(1, 1, 2);
        patterns[0].addSquare(2, 2, 2);
        patterns[0].addSquare(3, 3, 2);

        patterns[0].setNextPattern(patterns[1]);
        patterns[0].setPreviousPattern(patterns[3]);

        patterns[1].addSquare(0, 2, 0);
        patterns[1].addSquare(1, 2, 1);
        patterns[1].addSquare(2, 2, 2);
        patterns[1].addSquare(3, 2, 3);

        patterns[1].setNextPattern(patterns[2]);
        patterns[1].setPreviousPattern(patterns[0]);

        patterns[2].addSquare(0, 0, 1);
        patterns[2].addSquare(1, 1, 1);
        patterns[2].addSquare(2, 2, 1);
        patterns[2].addSquare(3, 3, 1);

        patterns[2].setNextPattern(patterns[3]);
        patterns[2].setPreviousPattern(patterns[1]);

        patterns[3].addSquare(0, 1, 0);
        patterns[3].addSquare(1, 1, 1);
        patterns[3].addSquare(2, 1, 2);
        patterns[3].addSquare(3, 1, 3);

        patterns[3].setNextPattern(patterns[0]);
        patterns[3].setPreviousPattern(patterns[2]);

        currentPattern = patterns[0];

        color = Color.CYAN;

        type = PieceType.I;
    }
}