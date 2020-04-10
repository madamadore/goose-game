package it.matteoavanzini.game.goose.action;

import it.matteoavanzini.game.goose.GameBoard;
import it.matteoavanzini.game.goose.exception.InvalidActionException;
import it.matteoavanzini.game.goose.model.Player;
import it.matteoavanzini.game.goose.tile.Tile;

public class BounceAction extends MoveAction {
    
    private GameBoard game;

    public BounceAction(Player player, int... rollDice) {
        super(player, rollDice);
        this.player = player;
        this.game = player.getGame();
        this.message = "%s bounces! %s returns to %s";
    }

    @Override
    public Object[] getMessageParameters() {
        return new Object[] { 
            player.getName(),
            player.getName(),
            player.getPosition().getNumber()
         };
    }

    @Override
    public boolean executeAction() throws InvalidActionException {

        Tile previousPlayerPosition = player.getPreviousPosition();
        Tile finalTile = game.getFinalTile();
        int sum = diceRoll.getSum();

        int arrivalNumber = previousPlayerPosition.getNumber() + sum;
        int bounce = arrivalNumber - finalTile.getNumber();
        arrivalNumber = finalTile.getNumber() - bounce;

        Tile arrival = game.getTile(arrivalNumber);
        player.moveTo(arrival);

        return true;
    }

}