package it.matteoavanzini.game.goose.action;

import it.matteoavanzini.game.goose.GameBoard;
import it.matteoavanzini.game.goose.exception.InvalidActionException;
import it.matteoavanzini.game.goose.model.Player;
import it.matteoavanzini.game.goose.tile.Tile;

public class PrankAction extends AbstractAction {

    private Tile fromTile;
    private Player player;
    private Tile tile;
    private Player occupant;

    public PrankAction(Player player, Tile fromTile) {
        this.player = player;
        this.fromTile = fromTile;
        this.tile = player.getPosition();
        this.message = "On %s there is %s, who returns to %s";
    }

    @Override
    public boolean executeAction() throws InvalidActionException {
        this.occupant = tile.getOccupants().get(0);
        fromTile.addOccupant(occupant);
        tile.removeOccupant(occupant);
        return true;
    }

    @Override
    public Object[] getMessageParameters() {
        return new Object[] { 
            player.getPosition().toString(),
            occupant.getName(),
            fromTile.toString()
         };
    }
}