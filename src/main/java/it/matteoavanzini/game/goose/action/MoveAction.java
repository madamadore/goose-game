package it.matteoavanzini.game.goose.action;

import it.matteoavanzini.game.goose.GameBoard;
import it.matteoavanzini.game.goose.event.ActionEvent;
import it.matteoavanzini.game.goose.event.ActionListener;
import it.matteoavanzini.game.goose.event.OnMoveEvent;
import it.matteoavanzini.game.goose.model.DiceRoll;
import it.matteoavanzini.game.goose.model.Player;
import it.matteoavanzini.game.goose.tile.Tile;

public class MoveAction extends AbstractAction<OnMoveEvent> {

    protected Player player;
    protected DiceRoll diceRoll;
    protected GameBoard game;
    protected Tile startingTile;
    protected Tile arrivalTile;

    public MoveAction(Player player, int... rollDice) {
        this.player = player;
        this.startingTile = player.getPosition();
        this.message = "%s rolls %d, %d. %s moves from %s to %s";
        if (rollDice.length > 0) {
            this.diceRoll = player.getGame().getDiceRoll();
            diceRoll.setRoll(rollDice);
        } else {
            this.diceRoll = player.getGame().rollDice();
        }
    }

    @Override
    public OnMoveEvent getEvent() {
        Tile finalTile = game.getFinalTile();
        int sum = diceRoll.getSum();
        
        int arrivalNumber = startingTile.getNumber() + sum;
        if (arrivalNumber > finalTile.getNumber()) {
            arrivalNumber = finalTile.getNumber();  
        }

        arrivalTile = game.getTile(arrivalNumber);
        this.message = formatMessage(getMessageParameters());

        return new OnMoveEvent((ActionListener<OnMoveEvent>) player, startingTile, arrivalTile);
    }

    @Override
    public Object[] getMessageParameters() {
        return new Object[] { 
            player.getName(),
            diceRoll.getResult()[0],
            diceRoll.getResult()[1],
            player.getName(),
            startingTile.toString(),
            arrivalTile.toString()
         };
    }

}