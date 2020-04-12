package it.matteoavanzini.game.goose.action;

import it.matteoavanzini.game.goose.GameBoard;
import it.matteoavanzini.game.goose.exception.InvalidActionException;
import it.matteoavanzini.game.goose.model.Player;
import it.matteoavanzini.game.goose.tile.Tile;

public class BounceAction extends MoveAction {
    
    private Tile fromTile;

    public BounceAction(Player player, Tile fromTile) {
        super(player, player.getGame().getDiceRoll().getResult());
        this.fromTile = fromTile;
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

        GameBoard game = player.getGame();
        Tile finalTile = game.getFinalTile();
        int sum = diceRoll.getSum();

        int arrivalNumber = fromTile.getNumber() + sum;
        int bounce = arrivalNumber - finalTile.getNumber();
        arrivalNumber = finalTile.getNumber() - bounce;

        Tile arrival = game.getTile(arrivalNumber);
        player.moveTo(arrival);

        return true;
    }

}