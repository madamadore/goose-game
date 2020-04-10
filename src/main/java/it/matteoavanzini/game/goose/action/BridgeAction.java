package it.matteoavanzini.game.goose.action;

import it.matteoavanzini.game.goose.GameBoard;
import it.matteoavanzini.game.goose.exception.InvalidActionException;
import it.matteoavanzini.game.goose.model.Player;
import it.matteoavanzini.game.goose.tile.Tile;

public class BridgeAction extends AbstractAction {

    private Tile tile;
    private Player player;

    BridgeAction(Tile tile) {
        this.tile = tile;
        this.player = tile.getLastOccupant();
        this.message = "%s jumps to %s";
    }

    @Override
    public boolean executeAction() throws InvalidActionException {
        Player player = tile.getLastOccupant();
        GameBoard game = player.getGame();
        Tile arrival = game.getTile(12);
        player.moveTo(arrival);

		return true;
    }

    @Override
    public Object[] getMessageParameters() {
        return new Object[] { 
            player.getName(),
            player.getPosition().toString()
         };
    }
}