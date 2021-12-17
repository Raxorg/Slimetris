package com.frontanilla.slimetris.util;

import com.badlogic.gdx.math.MathUtils;
import com.frontanilla.slimetris.newPieces.IPiece;
import com.frontanilla.slimetris.newPieces.JPiece;
import com.frontanilla.slimetris.newPieces.LPiece;
import com.frontanilla.slimetris.newPieces.OPiece;
import com.frontanilla.slimetris.newPieces.Piece;
import com.frontanilla.slimetris.newPieces.SPiece;
import com.frontanilla.slimetris.newPieces.TPiece;
import com.frontanilla.slimetris.newPieces.ZPiece;

public class RandomUtils {

    public static Piece randomPiece() {
        switch (MathUtils.random(6)) {
            case 0:
                return new OPiece();
            case 1:
                return new JPiece();
            case 2:
                return new TPiece();
            case 3:
                return new SPiece();
            case 4:
                return new ZPiece();
            case 5:
                return new IPiece();
            default:
                return new LPiece();
        }
    }
}