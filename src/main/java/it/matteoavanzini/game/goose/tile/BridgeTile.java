package it.matteoavanzini.game.goose.tile;

import it.matteoavanzini.game.goose.GameContext;
import it.matteoavanzini.game.goose.event.ActionBuilder;
import it.matteoavanzini.game.goose.event.OnBridgeEvent;
import it.matteoavanzini.game.goose.event.OnMoveEvent;

public class BridgeTile extends AbstractTile {

    public BridgeTile(GameContext game, int number) {
        super(game, number);
        this.name = "The Bridge";
    }

    @Override
    public void onLand(OnMoveEvent e) {
        ActionBuilder actionBuilder = actionDispatcher.getActionBuilder();
        OnBridgeEvent bridge = actionBuilder.getBridgeEvent(e.getPlayer());
        actionDispatcher.dispatchEvent(bridge);
    }
}