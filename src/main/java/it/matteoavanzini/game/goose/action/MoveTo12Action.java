package it.matteoavanzini.game.goose.action;

import java.util.ArrayList;

import it.matteoavanzini.game.goose.GameBoard;
import it.matteoavanzini.game.goose.exception.InvalidActionException;
import it.matteoavanzini.game.goose.model.Player;
import it.matteoavanzini.game.goose.tile.Tile;

public class MoveTo12Action extends AbstractAction {

    private Tile tile;

    MoveTo12Action(Tile tile) {
        this.tile = tile;
        this.message = "%s jumps to %s";
    }

    @Override
    public ActionResult execute() throws InvalidActionException {
        Player player = tile.getLastOccupant();
        GameBoard game = player.getGame();
        Tile arrival = game.getTile(12);
        ActionResult result = player.moveTo(arrival);

		return buildResult(new ArrayList<Object>() {{
                add(player.getName());
                add(arrival.toString()); 
            }}, result);
    }
}