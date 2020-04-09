package it.matteoavanzini.game.goose.action;

import java.util.ArrayList;
import java.util.List;

import it.matteoavanzini.game.goose.GameBoard;
import it.matteoavanzini.game.goose.exception.InvalidActionException;
import it.matteoavanzini.game.goose.model.DiceRoll;
import it.matteoavanzini.game.goose.model.Player;
import it.matteoavanzini.game.goose.tile.Tile;

public class BounceAction extends MoveAction {
    
    public BounceAction(Player player, int... rollDice) {
        this.player = player;
        this.message = "%s bounces! %s returns to %s";
    }

    @Override
    public ActionResult execute() throws InvalidActionException {

        List<Object> messageParameters = new ArrayList<>();
        GameBoard game = player.getGame();
        Tile currentPlayerPosition = player.getPosition();
        Tile finalTile = game.getFinalTile();
        int sum = diceRoll.getSum();

        int arrivalNumber = currentPlayerPosition.getNumber() + sum;
        if (currentPlayerPosition.getNumber() > finalTile.getNumber()) {
            
            int bounce = arrivalNumber - finalTile.getNumber();
            arrivalNumber = finalTile.getNumber() - bounce;

            Tile arrival = game.getTile(arrivalNumber);
            ActionResult result = player.moveTo(arrival);

            messageParameters.add(player.getName());
            messageParameters.add(player.getName());
            messageParameters.add(arrivalNumber);
            return buildResult(messageParameters, result);
        }
        return null;
    }

}