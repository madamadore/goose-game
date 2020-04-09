package it.matteoavanzini.game.goose.action;

import java.util.ArrayList;
import java.util.List;

import it.matteoavanzini.game.goose.GameBoard;
import it.matteoavanzini.game.goose.exception.InvalidActionException;
import it.matteoavanzini.game.goose.model.DiceRoll;
import it.matteoavanzini.game.goose.model.Player;
import it.matteoavanzini.game.goose.tile.Tile;

public class MoveAction extends AbstractAction {

    protected Player player;
    protected DiceRoll diceRoll;
    
    private String winsMessage = "%s Wins!!";
    private String bounceMessage = "%s bounces! %s returns to %s";

    public MoveAction(Player player, int... rollDice) {
        this.player = player;
        this.message = "%s rolls %d, %d. %s moves from %s to %s";
        if (rollDice.length > 0) {
            this.diceRoll = player.getGame().getDiceRoll();
            diceRoll.setRoll(rollDice);
        } else {
            this.diceRoll = player.getGame().rollDice();
        }
    }

    @Override
    public ActionResult execute() throws InvalidActionException {

        GameBoard game = player.getGame();
        Tile startingTile = player.getPosition();
        Tile finalTile = game.getFinalTile();
        int sum = diceRoll.getSum();
        int[] roll = diceRoll.getResult();
        
        List<Object> messageParameters = new ArrayList<>();
        messageParameters.add(player.getName());
        messageParameters.add(roll[0]);
        messageParameters.add(roll[1]);
        messageParameters.add(player.getName());
        messageParameters.add(startingTile.toString());
 
        int arrivalNumber = startingTile.getNumber() + sum;
        if (arrivalNumber > finalTile.getNumber()) {
            // bounce
            int bounce = arrivalNumber - finalTile.getNumber();
            this.message += ". " + bounceMessage;
            arrivalNumber = finalTile.getNumber() - bounce;

            messageParameters.add(finalTile.toString());
            messageParameters.add(player.getName());
            messageParameters.add(player.getName());
        } 
        Tile arrival = game.getTile(arrivalNumber);
        messageParameters.add(arrival.toString());

        if (arrival.equals(finalTile)) {
            // wins
            game.endGame();

            this.message += ". " + winsMessage;
            messageParameters.add(player.getName());
        }
        
        ActionResult result = player.moveTo(arrival);

		return buildResult(messageParameters, result);
    }

}