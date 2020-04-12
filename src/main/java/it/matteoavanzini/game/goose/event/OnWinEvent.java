package it.matteoavanzini.game.goose.event;

import it.matteoavanzini.game.goose.GameContext;
import it.matteoavanzini.game.goose.model.Player;

public class OnWinEvent extends AbstractActionEvent {

    private Player player;
    
    public OnWinEvent(GameContext ctx, Player player) {
        this.player = player;
        this.message = "%s Wins!!";
        this.message = formatMessage();
    }

    @Override
    public Object[] getMessageParameters() {
        return new Object[] { 
            player.getName()
        };
    }
}