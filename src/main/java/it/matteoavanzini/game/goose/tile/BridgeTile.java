package it.matteoavanzini.game.goose.tile;

import it.matteoavanzini.game.goose.GameBoard;
import it.matteoavanzini.game.goose.action.Action;
import it.matteoavanzini.game.goose.action.BridgeAction;

public class BridgeTile extends AbstractTile {

    public BridgeTile(GameBoard game, int number) {
        super(game, number);
        this.name = "The Bridge";
    }

    public Action getAction() {
        return new BridgeAction(getLastOccupant());
    }
}