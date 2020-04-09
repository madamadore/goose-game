package it.matteoavanzini.game.goose.tile;

import it.matteoavanzini.game.goose.GameBoard;
import it.matteoavanzini.game.goose.action.Action;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SimpleTile extends AbstractTile {

    public Action getAction() {
        return null;
    }
    
    public SimpleTile(GameBoard game, int number) {
        super(game, number);
    }

    public SimpleTile(GameBoard game, int number, String name) {
        super(game, number);
        this.name = name;
    }
}