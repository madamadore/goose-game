package it.matteoavanzini.game.goose.tile;

import it.matteoavanzini.game.goose.GameContext;
import it.matteoavanzini.game.goose.event.ActionBuilder;
import it.matteoavanzini.game.goose.event.OnBounceEvent;
import it.matteoavanzini.game.goose.event.OnMoveEvent;
import it.matteoavanzini.game.goose.event.OnWinEvent;
import it.matteoavanzini.game.goose.model.Player;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EndTile extends AbstractTile {

    @Override
    public void onLand(OnMoveEvent e) {
        ActionBuilder actionBuilder = actionDispatcher.getActionBuilder();

        Player player = e.getPlayer();
        int diceSum = e.getDiceSum();
        
        Tile from = e.getStartingTile();
        int totalSum = from.getNumber() + diceSum;
        
        if (totalSum > getNumber()) {
            OnBounceEvent bounceEvent = actionBuilder.getBounceEvent(player);
            actionDispatcher.dispatchEvent(bounceEvent);
        } else {
            OnWinEvent winEvent = actionBuilder.getWinEvent(player);
            actionDispatcher.dispatchEvent(winEvent);
        }

    }
    
    public EndTile(GameContext game, int number) {
        this(game, number, Integer.toString(number));
    }

    public EndTile(GameContext game, int number, String name) {
        super(game, number);
        this.name = name;
    }
}