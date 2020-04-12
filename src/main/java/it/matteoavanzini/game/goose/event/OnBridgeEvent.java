package it.matteoavanzini.game.goose.event;

import it.matteoavanzini.game.goose.GameContext;
import it.matteoavanzini.game.goose.model.Player;
import it.matteoavanzini.game.goose.tile.Tile;

public class OnBridgeEvent extends OnMoveEvent {

    private Player player;
    private Tile arrival;
    
    public OnBridgeEvent(GameContext ctx, Player player) {
        super(ctx, player);
        this.player = player;
        this.message = "%s jumps to %s";
        this.arrival = ctx.getTile(12);
        this.message = formatMessage();
    }

    @Override
    protected Object[] getMessageParameters() {
        return new Object[] { 
            player.getName(),
            arrival.getName()
         };
    }
}