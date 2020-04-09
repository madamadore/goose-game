package it.matteoavanzini.game.goose.action;

import java.util.ArrayList;

import it.matteoavanzini.game.goose.exception.InvalidActionException;
import it.matteoavanzini.game.goose.model.Player;
import it.matteoavanzini.game.goose.tile.Tile;

public class PrankAction extends AbstractAction {

    private Player player;
    private Tile tile;

    PrankAction(Player player, Tile tile) {
        this.player = player;
        this.tile = tile;
        this.message = "On %s there is %s, who returns to %s";
    }

    @Override
    public ActionResult execute() throws InvalidActionException {
        Player occupant = tile.getOccupants().get(0);
        Tile from = player.getPosition();
        from.addOccupant(occupant);
        tile.removeOccupant(occupant);

        return buildResult(new ArrayList<Object>() {{
            add(tile.toString());
            add(occupant.getName()); 
            add(from.toString());
        }});
    }

}