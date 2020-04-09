package it.matteoavanzini.game.goose.action;

import it.matteoavanzini.game.goose.GameBoard;
import it.matteoavanzini.game.goose.model.Player;
import it.matteoavanzini.game.goose.tile.Tile;

public class DefaultActionBuilder implements ActionBuilder {

    public Action getAddPlayerAction(GameBoard game, String name) {
        return new AddPlayerAction(game, name);
    }

    public Action getBridgeAction(Tile tile) {
        return new MoveTo12Action(tile);
    }

    public Action getGooseAction(Tile tile) {
        return new GooseAction(tile);
    }

    public Action getPrankAction(Player player, Tile tile) {
        return new PrankAction(player, tile);
    }

    public Action getMoveAction(Player player, int... rollDice) {
        return new MoveAction(player, rollDice);
    }
}