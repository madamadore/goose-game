package it.matteoavanzini.game.goose.action;

import it.matteoavanzini.game.goose.GameBoard;
import it.matteoavanzini.game.goose.exception.InvalidActionException;
import it.matteoavanzini.game.goose.model.DiceRoll;
import it.matteoavanzini.game.goose.model.Player;
import it.matteoavanzini.game.goose.tile.Tile;

public class MoveAction extends AbstractAction {

    protected Player player;
    protected DiceRoll diceRoll;
    protected GameBoard game;
    protected Tile startingTile;
    protected Tile arrivalTile;

    public MoveAction(Player player, int... rollDice) {
        this.player = player;
        this.game = player.getGame();
        this.startingTile = player.getPosition();
        this.message = "%s rolls %d, %d. %s moves from %s to %s";
        if (rollDice.length > 0) {
            this.diceRoll = player.getGame().getDiceRoll();
            diceRoll.setRoll(rollDice);
        } else {
            player.getGame().getDiceRoll().roll();
            this.diceRoll = player.getGame().getDiceRoll();
        }
    }

    @Override
    public boolean executeAction() throws InvalidActionException {
        Tile finalTile = game.getFinalTile();
        int sum = diceRoll.getSum();
        
        int arrivalNumber = startingTile.getNumber() + sum;
        if (arrivalNumber > finalTile.getNumber()) {
            arrivalNumber = finalTile.getNumber();  
        }

        arrivalTile = game.getTile(arrivalNumber);
        player.moveTo(arrivalTile);

		return true;
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