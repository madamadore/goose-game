package it.matteoavanzini.game.goose.model;

import it.matteoavanzini.game.goose.tile.Tile;

public interface Player {
    Tile getPosition();
    void setPosition(Tile tile);
    String getName();
    DiceRoll getDiceRoll();
}