package it.matteoavanzini.game.goose.model;

import it.matteoavanzini.game.goose.GameBoard;
import it.matteoavanzini.game.goose.action.ActionResult;
import it.matteoavanzini.game.goose.exception.InvalidActionException;
import it.matteoavanzini.game.goose.tile.Tile;

public interface Player {
    Tile getPosition();
    void setPosition(Tile tile);
    String getName();
    ActionResult moveTo(Tile arrival) throws InvalidActionException;
    int hashCode();
    boolean equals(Object obj);
    GameBoard getGame();
}