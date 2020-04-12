package it.matteoavanzini.game.goose.model;

import it.matteoavanzini.game.goose.GameBoard;
import it.matteoavanzini.game.goose.tile.Tile;

public class GoosePlayer implements Player {
    
    private Tile position;
    private String name;
    private GameBoard game;

    public GoosePlayer(GameBoard game, String name) {
        this.position = game.getStartingTile();
        this.name = name;
        this.game = game;
    }

    public void moveTo(Tile arrival) {
        position.removeOccupant(this);
		arrival.onLand(this);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Player) {
            return ((Player) obj).getName().equals(this.getName());
        }
        return false;
    }

    @Override
    public void setPosition(Tile tile) {
        this.position = tile;
    }

    @Override
    public Tile getPosition() {
        return position;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public GameBoard getGame() {
        return game;
    }
}