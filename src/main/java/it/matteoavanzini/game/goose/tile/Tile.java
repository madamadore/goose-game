package it.matteoavanzini.game.goose.tile;

import java.util.List;

import it.matteoavanzini.game.goose.GameBoard;
import it.matteoavanzini.game.goose.action.Action;
import it.matteoavanzini.game.goose.action.ActionResult;
import it.matteoavanzini.game.goose.exception.InvalidActionException;
import it.matteoavanzini.game.goose.model.Player;

public interface Tile {
    List<Player> getOccupants();
    ActionResult onLand(Player p) throws InvalidActionException;
    void addOccupant(Player p);
    void removeOccupant(Player p);
    int getNumber();
    String getName();
    GameBoard getGame();
    Action getAction();
    Player getLastOccupant();
}