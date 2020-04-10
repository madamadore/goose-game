package it.matteoavanzini.game.goose.model;

import it.matteoavanzini.game.goose.GameBoard;
import it.matteoavanzini.game.goose.tile.Tile;

public interface Player {
    Tile getPreviousPosition();
    Tile getPosition();
    void setPosition(Tile tile);
    String getName();
    void moveTo(Tile arrival);
    int hashCode();
    boolean equals(Object obj);
    GameBoard getGame();
}