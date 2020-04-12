package it.matteoavanzini.game.goose.event;

import it.matteoavanzini.game.goose.GameContext;
import it.matteoavanzini.game.goose.model.Player;

public class OnBounceEvent extends OnMoveEvent {

    private Player player;
    
    public OnBounceEvent(GameContext ctx, Player player) {
        super(ctx, player);
        this.player = player;
        this.message = "%s bounces! %s returns to %s";

        int bounce = startingTile.getNumber() + diceSum - ctx.getTilesCount();
        this.arrivalTile = ctx.getTile(ctx.getTilesCount() - bounce);
        
        this.message = formatMessage();
    }

    @Override
    public Object[] getMessageParameters() {
        return new Object[] { 
            player.getName(),
            player.getName(),
            player.getPosition().getNumber()
         };
    }
}