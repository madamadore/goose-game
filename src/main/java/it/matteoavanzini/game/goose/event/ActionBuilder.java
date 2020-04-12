package it.matteoavanzini.game.goose.event;

import it.matteoavanzini.game.goose.model.Player;

public interface ActionBuilder {
    OnAddPlayerEvent getAddPlayerEvent(String name);
    OnGooseEvent getGooseEvent(Player player);
    OnMoveEvent getMoveEvent(Player player);
    OnBridgeEvent getBridgeEvent(Player player);
    OnWinEvent getWinEvent(Player player);
    OnBounceEvent getBounceEvent(Player player);
    OnPrankEvent getPrankEvent(Player player);
}