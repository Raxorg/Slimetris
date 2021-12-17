package com.frontanilla.slimetris.stuff;

import com.badlogic.gdx.utils.DelayedRemovalArray;
import com.frontanilla.slimetris.GameAssets;
import com.frontanilla.slimetris.newPieces.IPiece;
import com.frontanilla.slimetris.newPieces.Piece;

public class GameStuff {

    private GameAssets gameAssets;
    // Stuff
    private PlatformerPlayer platformerPlayer1;
    private Grid grid;
    private Piece currentPiece;
    private DelayedRemovalArray<Piece> pieces;

    public void init() {
        platformerPlayer1 = new PlatformerPlayer(gameAssets.getPlayer());
        grid = new Grid();
        pieces = new DelayedRemovalArray<>();
    }

    public void setAssets(GameAssets gameAssets) {
        this.gameAssets = gameAssets;
    }

    public PlatformerPlayer getPlatformerPlayer1() {
        return platformerPlayer1;
    }

    public Grid getGrid() {
        return grid;
    }

    public Piece getCurrentPiece() {
        return currentPiece;
    }

    public void setCurrentPiece(Piece currentPiece) {
        this.currentPiece = currentPiece;
    }

    public DelayedRemovalArray<Piece> getPieces() {
        return pieces;
    }
}