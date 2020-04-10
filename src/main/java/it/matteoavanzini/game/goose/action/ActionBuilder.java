package it.matteoavanzini.game.goose.action;

import it.matteoavanzini.game.goose.GameBoard;
import it.matteoavanzini.game.goose.model.Player;
import it.matteoavanzini.game.goose.tile.Tile;

public interface ActionBuilder {

    Action getQuitAction(GameBoard game);
    Action getAddPlayerAction(GameBoard game, String name);
    Action getBridgeAction(Tile tile);
    Action getGooseAction(Tile tile);
    Action getPrankAction(Player player, Tile tile);
    Action getMoveAction(Player player, int... rollDice);
}