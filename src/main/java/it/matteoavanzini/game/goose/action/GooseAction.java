package it.matteoavanzini.game.goose.action;

import it.matteoavanzini.game.goose.GameBoard;
import it.matteoavanzini.game.goose.exception.InvalidActionException;
import it.matteoavanzini.game.goose.model.DiceRoll;
import it.matteoavanzini.game.goose.model.Player;
import it.matteoavanzini.game.goose.tile.Tile;

public class GooseAction extends AbstractAction {

    private Tile tile;
    private Player player;
    private String arrivalTileName;
    
    public GooseAction(Player player) {
        this.player = player;
        this.tile = player.getPosition();
        this.message = "%s moves again and goes to %s";
    }

    @Override
    public Object[] getMessageParameters() {
        return new Object[] { 
            player.getName(),
            arrivalTileName
         };
    }

    @Override
    public boolean executeAction() throws InvalidActionException {
        
        GameBoard game = player.getGame();
        DiceRoll roll = game.getDiceRoll();
        int arrivalNumber = tile.getNumber() + roll.getSum();

        Tile arrival = game.getTile(arrivalNumber);
        this.arrivalTileName = arrival.toString();
        player.moveTo(arrival);

		return true;
    }
}