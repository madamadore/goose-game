package it.matteoavanzini.game.goose.model;

import it.matteoavanzini.game.goose.GameBoard;
import it.matteoavanzini.game.goose.tile.Tile;

public interface Player {
    Tile getPosition();
    void setPosition(Tile tile);
    String getName();
    void moveTo(Tile arrival);
    GameBoard getGame();
}