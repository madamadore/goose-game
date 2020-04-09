package it.matteoavanzini.game.goose.action;

import java.util.ArrayList;

import it.matteoavanzini.game.goose.GameBoard;
import it.matteoavanzini.game.goose.exception.InvalidActionException;
import it.matteoavanzini.game.goose.model.DiceRoll;
import it.matteoavanzini.game.goose.model.Player;
import it.matteoavanzini.game.goose.tile.Tile;

public class GooseAction extends AbstractAction {

    private Tile tile;
    
    GooseAction(Tile tile) {
        this.tile = tile;
        this.message = "%s moves again and goes to %s";
    }

    @Override
    public ActionResult execute() throws InvalidActionException {
        Player player = tile.getLastOccupant();
        GameBoard game = player.getGame();
        DiceRoll roll = game.getDiceRoll();
        int arrivalNumber = tile.getNumber() + roll.getSum();

        Tile arrival = game.getTile(arrivalNumber);
        ActionResult subAction = player.moveTo(arrival);

		return buildResult(new ArrayList<Object>() {{
            add(player.getName());
            add(arrival.toString()); 
        }}, subAction);
    }
}