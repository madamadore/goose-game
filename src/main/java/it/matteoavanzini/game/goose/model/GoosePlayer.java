package it.matteoavanzini.game.goose.model;

import it.matteoavanzini.game.goose.GameBoard;
import it.matteoavanzini.game.goose.action.ActionResult;
import it.matteoavanzini.game.goose.exception.InvalidActionException;
import it.matteoavanzini.game.goose.tile.Tile;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class GoosePlayer implements Player {
    private Tile position;
    private String name;
    private GameBoard game;

    public ActionResult moveTo(Tile arrival) throws InvalidActionException {
        position.removeOccupant(this);
		return arrival.onLand(this);
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

    
}