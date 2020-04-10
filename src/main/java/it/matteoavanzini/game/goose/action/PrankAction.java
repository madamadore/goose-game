package it.matteoavanzini.game.goose.action;

import it.matteoavanzini.game.goose.exception.InvalidActionException;
import it.matteoavanzini.game.goose.model.Player;
import it.matteoavanzini.game.goose.tile.Tile;

public class PrankAction extends AbstractAction {

    private Player player;
    private Tile tile;
    private Player occupant;

    PrankAction(Player player, Tile tile) {
        this.player = player;
        this.tile = tile;
        this.message = "On %s there is %s, who returns to %s";
    }

    @Override
    public boolean executeAction() throws InvalidActionException {
        this.occupant = tile.getOccupants().get(0);
        Tile fromTile = player.getPosition();
        fromTile.addOccupant(occupant);
        tile.removeOccupant(occupant);
        return true;
    }

    @Override
    public Object[] getMessageParameters() {
        return new Object[] { 
            player.getPosition().toString(),
            occupant.getName(),
            player.getPreviousPosition().toString()
         };
    }
}