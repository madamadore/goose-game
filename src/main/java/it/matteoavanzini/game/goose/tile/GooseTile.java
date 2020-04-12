package it.matteoavanzini.game.goose.tile;

import it.matteoavanzini.game.goose.GameContext;
import it.matteoavanzini.game.goose.event.ActionBuilder;
import it.matteoavanzini.game.goose.event.OnGooseEvent;
import it.matteoavanzini.game.goose.event.OnMoveEvent;

public class GooseTile extends AbstractTile {

    public GooseTile(GameContext game, int number) {
        super(game, number);
        this.name = "The Goose";
    }

    @Override
    public void onLand(OnMoveEvent e) {
        ActionBuilder actionBuilder = actionDispatcher.getActionBuilder();
        OnGooseEvent goose = actionBuilder.getGooseEvent(e.getPlayer());
        actionDispatcher.dispatchEvent(goose);
    }

    @Override
    public String toString() {
        return this.number + ", " + this.name;
    }
}