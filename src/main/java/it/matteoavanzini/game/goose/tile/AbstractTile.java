package it.matteoavanzini.game.goose.tile;

import java.util.ArrayList;
import java.util.List;

import it.matteoavanzini.game.goose.GameBoard;
import it.matteoavanzini.game.goose.action.Action;
import it.matteoavanzini.game.goose.action.PrankAction;
import it.matteoavanzini.game.goose.model.Player;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class AbstractTile implements Tile {
    
    protected List<Player> occupants;
    protected int number;
    protected String name;
    protected GameBoard game;

    AbstractTile(GameBoard game, int i) {
        this.game = game;
        number = i;
        name = Integer.toString(number);
        occupants = new ArrayList<>();
    }

    @Override
    public void onLand(Player p) {
        this.addOccupant(p);

        if (game.isPrankster() && this.occupants.size() > 1) {
            PrankAction prank = (PrankAction) game.getActionBuilder().getPrankAction(p, this);
            game.dispatchAction(prank);
        }
        
		if (getAction() != null) {
            Action action = getAction();
            game.dispatchAction(action);
        }
	}
	
	public void addOccupant(Player p) {
        this.occupants.add(p);
        p.setPosition(this);
    }

    public void removeOccupant(Player p) {
        this.occupants.remove(p);
    }

    public Player getLastOccupant() {
        return this.occupants.get( occupants.size() - 1 );
    }

    @Override
    public String toString() {
        return this.name;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Tile) {
            return ((Tile) o).getNumber()==this.getNumber();
        }
        return false;
    }

    @Override
    public int hashCode() {
        return number;
    }
}