package it.matteoavanzini.game.goose.tile;

import java.util.ArrayList;
import java.util.List;

import it.matteoavanzini.game.goose.GameBoard;
import it.matteoavanzini.game.goose.action.Action;
import it.matteoavanzini.game.goose.action.ActionBuilder;
import it.matteoavanzini.game.goose.action.ActionResult;
import it.matteoavanzini.game.goose.action.PrankAction;
import it.matteoavanzini.game.goose.exception.InvalidActionException;
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

    public ActionResult onLand(Player p) throws InvalidActionException {
        ActionResult result = null;
        if (game.isPrankster() && this.occupants.size() > 0) {
            ActionBuilder actionBuilder = game.getActionBuilder();
            PrankAction prank = (PrankAction) actionBuilder.getPrankAction(p, this);
            result = prank.execute();
		}
        this.addOccupant(p);
        
		if (getAction() != null) {
            Action action = getAction();
            ActionResult subResult = action.execute();

            if (result == null) {
                result = new ActionResult(true, subResult.getMessage(), null);
            } else {
                String message = result.getMessage() + subResult.getMessage();
                subResult.setMessage(message);
            }
        }
        
		return result;
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