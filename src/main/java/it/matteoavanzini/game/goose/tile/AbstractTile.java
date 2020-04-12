package it.matteoavanzini.game.goose.tile;

import java.util.ArrayList;
import java.util.List;

import it.matteoavanzini.game.goose.GameBoard;
import it.matteoavanzini.game.goose.action.Action;
import it.matteoavanzini.game.goose.action.PrankAction;
import it.matteoavanzini.game.goose.model.Player;

public abstract class AbstractTile implements Tile {
    
    protected List<Player> occupants;
    protected int number;
    protected String name;
    protected GameBoard game;
    protected Tile fromTile;

    AbstractTile(GameBoard game, int i) {
        this.game = game;
        number = i;
        name = Integer.toString(number);
        occupants = new ArrayList<>();
    }

    @Override
    public void onLand(Player p) {
        fromTile = p.getPosition();
        this.addOccupant(p);

        if (game.isPrankster() && this.occupants.size() > 1) {
            PrankAction prank = new PrankAction(p, fromTile);
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

    public List<Player> getOccupants() {
        return occupants;
    }

    public int getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    public GameBoard getGame() {
        return game;
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