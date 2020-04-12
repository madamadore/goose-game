package it.matteoavanzini.game.goose.action;

import it.matteoavanzini.game.goose.GameBoard;
import it.matteoavanzini.game.goose.event.OnMoveEvent;
import it.matteoavanzini.game.goose.exception.InvalidActionException;
import it.matteoavanzini.game.goose.model.Player;
import it.matteoavanzini.game.goose.tile.Tile;

public class BridgeAction extends MoveAction {

    private Tile startingTile;
    private Player player;

    BridgeAction(Tile startingTile, Player player) {
        super(player);
        this.message = "%s jumps to %s";
    }

    @Override
    public OnMoveEvent doAction() throws InvalidActionException {
        
        GameBoard game = player.getGame();
        Tile arrival = game.getTile(12);
        player.moveTo(arrival);

		return new OnMoveEvent(startingTile, arrival, null);
    }

    @Override
    public Object[] getMessageParameters() {
        return new Object[] { 
            player.getName(),
            player.getPosition().toString()
         };
    }
}