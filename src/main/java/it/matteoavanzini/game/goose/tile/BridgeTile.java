package it.matteoavanzini.game.goose.tile;

import it.matteoavanzini.game.goose.GameBoard;
import it.matteoavanzini.game.goose.action.Action;
import it.matteoavanzini.game.goose.action.ActionBuilder;

public class BridgeTile extends AbstractTile {

    public BridgeTile(GameBoard game, int number) {
        super(game, number);
        this.name = "The Bridge";
    }

    public Action getAction() {
        ActionBuilder actionBuilder = game.getActionBuilder();
        return actionBuilder.getBridgeAction(this);
    }
}