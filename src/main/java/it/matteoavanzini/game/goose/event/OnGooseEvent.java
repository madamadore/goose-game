package it.matteoavanzini.game.goose.event;

import it.matteoavanzini.game.goose.GameContext;
import it.matteoavanzini.game.goose.model.Player;
import it.matteoavanzini.game.goose.tile.Tile;

public class OnGooseEvent extends OnMoveEvent {

    private Player player;
    private Tile arrival;
    
    public OnGooseEvent(GameContext ctx, Player player) {
        super(ctx, player);
        this.player = player;
        this.message = "%s moves again and goes to %s";
        int diceRollSum = ctx.getDiceRoll().getSum();
        int arrivalIndex = player.getPosition().getNumber() + diceRollSum;
        this.arrival = ctx.getTile(arrivalIndex);
        this.message = formatMessage();
    }

    @Override
    public Object[] getMessageParameters() {
        return new Object[] { 
            player.getName(),
            arrival.getName()
         };
    }
}