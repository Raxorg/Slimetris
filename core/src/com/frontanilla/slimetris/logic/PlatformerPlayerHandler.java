package com.frontanilla.slimetris.logic;

import com.badlogic.gdx.math.Rectangle;
import com.frontanilla.slimetris.stuff.GameStuff;
import com.frontanilla.slimetris.newPieces.Square;

public class PlatformerPlayerHandler {

    private GameStuff stuff;
    // Logic
    private boolean onAir;
    private float yVelocity;

    public void update() {
        if (onAir) {
            yVelocity -= 5f;
        }
        Rectangle bounds = stuff.getPlatformerPlayer1().getBounds();
        bounds.y = Math.max(bounds.y + yVelocity, 0);
        verifyCollision();
        verifyFloating();
    }

    private void verifyCollision() {
        for (int i = 0; i < stuff.getPieces().size; i++) {
            int squares = stuff.getPieces().get(i).getCurrentPattern().getSquares().length;
            for (int j = 0; j < squares; j++) {
                Square square = stuff.getPieces().get(i).getCurrentPattern().getSquares()[squares - 1 - j];
                if (stuff.getPlatformerPlayer1().getBounds().overlaps(square.getBounds())) {
                    if (yVelocity < 0) {
                        onAir = false;
                        stuff.getPlatformerPlayer1().getBounds().y = square.getTop();
                    } else {
                        stuff.getPlatformerPlayer1().getBounds().y -= yVelocity;
                    }
                    yVelocity = 0;
                    break;
                }
            }
        }
        if (stuff.getPlatformerPlayer1().getBounds().y == 0) {
            onAir = false;
        }
    }

    private void verifyFloating() {
        if (stuff.getPlatformerPlayer1().getBounds().y > 0) {
            for (int i = 0; i < stuff.getPieces().size; i++) {
                int squares = stuff.getPieces().get(i).getCurrentPattern().getSquares().length;
                for (int j = 0; j < squares; j++) {
                    Square square = stuff.getPieces().get(i).getCurrentPattern().getSquares()[squares - 1 - j];
                    if (stuff.getPlatformerPlayer1().getDownBounds().overlaps(square.getBounds())) {
                        return;
                    }
                }
            }
            onAir = true;
        }
    }

    public void setStuff(GameStuff stuff) {
        this.stuff = stuff;
    }

    public void wPressed() {
        if (!onAir) {
            yVelocity = 50f;
            onAir = true;
        }
    }

    public void dPressed() {
        stuff.getPlatformerPlayer1().getBounds().x += 10f;
        for (int i = 0; i < stuff.getPieces().size; i++) {
            for (int j = 0; j < stuff.getPieces().get(i).getCurrentPattern().getSquares().length; j++) {
                Square square = stuff.getPieces().get(i).getCurrentPattern().getSquares()[j];
                if (stuff.getPlatformerPlayer1().getBounds().overlaps(square.getBounds())) {
                    stuff.getPlatformerPlayer1().getBounds().x -= 10f;
                    break;
                }
            }
        }
    }

    public void aPressed() {
        stuff.getPlatformerPlayer1().getBounds().x -= 10f;
        for (int i = 0; i < stuff.getPieces().size; i++) {
            for (int j = 0; j < stuff.getPieces().get(i).getCurrentPattern().getSquares().length; j++) {
                Square square = stuff.getPieces().get(i).getCurrentPattern().getSquares()[j];
                if (stuff.getPlatformerPlayer1().getBounds().overlaps(square.getBounds())) {
                    stuff.getPlatformerPlayer1().getBounds().x += 10f;
                    break;
                }
            }
        }
    }
}