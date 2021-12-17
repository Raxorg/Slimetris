package com.frontanilla.slimetris;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.frontanilla.slimetris.input.GameInput;
import com.frontanilla.slimetris.logic.GameLogic;
import com.frontanilla.slimetris.rendering.GameRenderer;
import com.frontanilla.slimetris.stuff.GameStuff;

public class SlimetrisGame extends Game {

    private GameLogic logic;
    private GameRenderer renderer;

    @Override
    public void create() {
        GameAssets assets = new GameAssets();
        logic = new GameLogic();
        renderer = new GameRenderer();
        GameStuff stuff = new GameStuff();
        GameInput input = new GameInput();

        logic.setAssets(assets);
        logic.setInput(input);
        logic.setStuff(stuff);
        logic.init();

        renderer.setStuff(stuff);

        stuff.setAssets(assets);
        stuff.init();

        input.setLogic(logic);
        Gdx.input.setInputProcessor(input);
    }

    @Override
    public void render() {
        logic.update(Gdx.graphics.getDeltaTime());
        renderer.render();
    }

    @Override
    public void dispose() {
        renderer.dispose();
    }
}
