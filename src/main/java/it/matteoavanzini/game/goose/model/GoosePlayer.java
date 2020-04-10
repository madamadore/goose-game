package it.matteoavanzini.game.goose.model;

import it.matteoavanzini.game.goose.GameBoard;
import it.matteoavanzini.game.goose.tile.Tile;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class GoosePlayer implements Player {
    private Tile position;
    private Tile previousPosition;
    private String name;
    private GameBoard game;

    public GoosePlayer(Tile position, String name, GameBoard game) {
        this.position = position;
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
        this.previousPosition = position;
        this.position = tile;
    }

    
}