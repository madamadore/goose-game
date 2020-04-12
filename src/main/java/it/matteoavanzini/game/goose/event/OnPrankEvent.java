package it.matteoavanzini.game.goose.event;

import it.matteoavanzini.game.goose.GameContext;
import it.matteoavanzini.game.goose.model.Player;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OnPrankEvent extends OnMoveEvent {

    public OnPrankEvent(GameContext context, Player player) {
        super(context, player);
        this.message = "On %s there is %s, who returns to %s";
        int difference = 
        player.getDiceRoll().setRoll(0, );
        this.formatMessage();
    }

    @Override
    public Object[] getMessageParameters() {
        return new Object[] { 
            player.getPosition().toString(),
            player.getName(),
            player.getPreviousPosition().toString()
         };
    }
}