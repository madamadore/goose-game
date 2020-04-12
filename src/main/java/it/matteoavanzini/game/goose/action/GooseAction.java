package it.matteoavanzini.game.goose.action;

import it.matteoavanzini.game.goose.GameBoard;
import it.matteoavanzini.game.goose.event.ActionListener;
import it.matteoavanzini.game.goose.event.OnMoveEvent;
import it.matteoavanzini.game.goose.model.DiceRoll;
import it.matteoavanzini.game.goose.model.Player;
import it.matteoavanzini.game.goose.tile.Tile;

public class GooseAction extends MoveAction {

    private Tile tile;
    private Player player;
    private String arrivalTileName;
    
    GooseAction(Tile tile) {
        super(tile.getOccupants().stream().reduce((first, second)->second).orElse(null));
        this.tile = tile;
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
    public OnMoveEvent getEvent() {
        
        GameBoard game = player.getGame();
        DiceRoll roll = game.getDiceRoll();
        int arrivalNumber = tile.getNumber() + roll.getSum();

        Tile arrival = game.getTile(arrivalNumber);
        this.arrivalTileName = arrival.toString();
        player.moveTo(arrival);

        this.message = formatMessage(getMessageParameters());
        OnMoveEvent event = new OnMoveEvent((ActionListener<OnMoveEvent>) player);
        
        return event;
    }
}