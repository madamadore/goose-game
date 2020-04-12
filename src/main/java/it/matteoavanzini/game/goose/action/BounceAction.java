package it.matteoavanzini.game.goose.action;

import it.matteoavanzini.game.goose.GameBoard;
import it.matteoavanzini.game.goose.event.OnMoveEvent;
import it.matteoavanzini.game.goose.exception.InvalidActionException;
import it.matteoavanzini.game.goose.model.Player;
import it.matteoavanzini.game.goose.tile.Tile;

public class BounceAction extends MoveAction {

    protected Tile finalTile;

    public BounceAction(Player player, Tile finalTile, int... rollDice) {
        super(player, rollDice);
        this.finalTile = finalTile;
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
    public OnMoveEvent getEvent() {

        Tile previousPlayerPosition = player.getPreviousPosition();
        int sum = diceRoll.getSum();

        int arrivalNumber = previousPlayerPosition.getNumber() + sum;
        int bounce = arrivalNumber - finalTile.getNumber();
        arrivalNumber = finalTile.getNumber() - bounce;

        Tile arrival = game.getTile(arrivalNumber);
        player.moveTo(arrival);

        OnMoveEvent moveEvent = new OnMoveEvent(player);
        return moveEvent;
    }

}