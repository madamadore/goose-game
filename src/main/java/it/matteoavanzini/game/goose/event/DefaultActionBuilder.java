package it.matteoavanzini.game.goose.event;

import it.matteoavanzini.game.goose.GameContext;
import it.matteoavanzini.game.goose.model.Player;

public class DefaultActionBuilder implements ActionBuilder {

    protected GameContext context;
    public DefaultActionBuilder(GameContext ctx) {
        this.context = ctx;
    }

    @Override
    public OnMoveEvent getMoveEvent(Player player) {
        return new OnMoveEvent(context, player);
    }

    @Override
    public OnBridgeEvent getBridgeEvent(Player player) {
        return new OnBridgeEvent(context, player);
    }

    @Override
    public OnAddPlayerEvent getAddPlayerEvent(String name) {
        return null;
    }

    @Override
    public OnGooseEvent getGooseEvent(Player player) {
        return new OnGooseEvent(context, player);
    }

    @Override
    public OnPrankEvent getPrankEvent(Player player) {
        return new OnPrankEvent(context, player);
    }

    @Override
    public OnWinEvent getWinEvent(Player player) {
        return new OnWinEvent(context, player);
    }

    @Override
    public OnBounceEvent getBounceEvent(Player player) {
        return new OnBounceEvent(context, player);
    }

   
}