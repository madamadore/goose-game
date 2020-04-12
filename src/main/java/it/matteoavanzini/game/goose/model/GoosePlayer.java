package it.matteoavanzini.game.goose.model;

import it.matteoavanzini.game.goose.GameContext;
import it.matteoavanzini.game.goose.event.OnBounceActionListener;
import it.matteoavanzini.game.goose.event.OnBounceEvent;
import it.matteoavanzini.game.goose.event.OnBridgeActionListener;
import it.matteoavanzini.game.goose.event.OnBridgeEvent;
import it.matteoavanzini.game.goose.event.OnGooseActionListener;
import it.matteoavanzini.game.goose.event.OnGooseEvent;
import it.matteoavanzini.game.goose.event.OnMoveEvent;
import it.matteoavanzini.game.goose.event.OnPrankActionListener;
import it.matteoavanzini.game.goose.event.OnPrankEvent;
import it.matteoavanzini.game.goose.tile.Tile;
import lombok.Getter;
import lombok.Setter;

public class GoosePlayer implements Player, OnBridgeActionListener, OnGooseActionListener, OnBounceActionListener,
        OnPrankActionListener {
    @Getter
    protected Tile position;
    @Getter
    protected String name;
    @Setter
    @Getter
    protected DiceRoll diceRoll;

    public GoosePlayer(final GameContext game, final String name) {
        this.position = game.getTile(0);
        this.name = name;
        this.diceRoll = game.getDiceRoll();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    @Override
    public boolean equals(final Object obj) {
        if (obj instanceof Player) {
            return ((Player) obj).getName().equals(this.getName());
        }
        return false;
    }

    @Override
    public void setPosition(final Tile tile) {
        this.position = tile;
    }

    @Override
    public void onMove(OnMoveEvent event) {
        position.removeOccupant(this);
        Tile arrival = event.getArrivalTile();
        arrival.onLand(event);
    }

    @Override
    public void onBounce(OnBounceEvent event) {
        onMove(event);
    }
    
    @Override
    public void onPrank(OnPrankEvent event) {
        onMove(event);
    }

    @Override
    public void onGoose(OnGooseEvent event) {
        onMove(event);
    }

    @Override
    public void onBridge(OnBridgeEvent event) {
        onMove(event);
    }
}