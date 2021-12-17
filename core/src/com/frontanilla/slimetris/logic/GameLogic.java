package com.frontanilla.slimetris.logic;

import com.frontanilla.slimetris.GameAssets;
import com.frontanilla.slimetris.input.GameInput;
import com.frontanilla.slimetris.stuff.GameStuff;

public class GameLogic {

    // Helpers
    private CollisionHandler collisionHandler;
    private InputHandler inputHandler;
    private PieceMovementHandler pieceMovementHandler;
    private PieceSpawnHandler pieceSpawnHandler;
    private PlatformerPlayerHandler platformerPlayerHandler;

    public GameLogic() {
        collisionHandler = new CollisionHandler();
        collisionHandler.setLogic(this);
        inputHandler = new InputHandler();
        inputHandler.setLogic(this);
        pieceMovementHandler = new PieceMovementHandler();
        pieceMovementHandler.setLogic(this);
        pieceSpawnHandler = new PieceSpawnHandler();
        platformerPlayerHandler = new PlatformerPlayerHandler();
    }

    public void init() {
        pieceSpawnHandler.init();
    }

    public void update(float delta) {
        inputHandler.update();
        pieceMovementHandler.update(delta);
        platformerPlayerHandler.update();
    }

    public void setAssets(GameAssets assets) {
        pieceSpawnHandler.setAssets(assets);
    }

    public void setInput(GameInput input) {
        inputHandler.setInput(input);
    }

    public void setStuff(GameStuff stuff) {
        collisionHandler.setStuff(stuff);
        pieceMovementHandler.setStuff(stuff);
        pieceSpawnHandler.setStuff(stuff);
        platformerPlayerHandler.setStuff(stuff);
    }

    public CollisionHandler getCollisionHandler() {
        return collisionHandler;
    }

    public InputHandler getInputHandler() {
        return inputHandler;
    }

    public PieceMovementHandler getPieceMovementHandler() {
        return pieceMovementHandler;
    }

    public PieceSpawnHandler getPieceSpawnHandler() {
        return pieceSpawnHandler;
    }

    public PlatformerPlayerHandler getPlatformerPlayerHandler() {
        return platformerPlayerHandler;
    }
}