package it.matteoavanzini.game.goose.tile;

import it.matteoavanzini.game.goose.GameBoard;
import it.matteoavanzini.game.goose.action.Action;
import it.matteoavanzini.game.goose.action.ActionBuilder;

public class GooseTile extends AbstractTile {

    public GooseTile(GameBoard game, int number) {
        super(game, number);
        this.name = "The Goose";
    }

    public Action getAction() {
        ActionBuilder actionBuilder = game.getActionBuilder();
        return actionBuilder.getGooseAction(this);
    }

    @Override
    public String toString() {
        return this.number + ", " + this.name;
    }
}