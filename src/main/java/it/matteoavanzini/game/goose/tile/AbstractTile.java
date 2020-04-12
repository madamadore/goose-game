package it.matteoavanzini.game.goose.tile;

import java.util.LinkedHashSet;
import java.util.Set;

import it.matteoavanzini.game.goose.GameContext;
import it.matteoavanzini.game.goose.event.ActionBuilder;
import it.matteoavanzini.game.goose.event.ActionDispatcher;
import it.matteoavanzini.game.goose.event.OnMoveEvent;
import it.matteoavanzini.game.goose.event.OnPrankEvent;
import it.matteoavanzini.game.goose.model.Player;
import lombok.Getter;

public abstract class AbstractTile implements Tile {
    
    @Getter
    protected int number;
    @Getter
    protected String name;
    protected GameContext game;
    protected ActionDispatcher actionDispatcher;
    @Getter
    private Set<Player> occupants;
    
    AbstractTile(GameContext game, int i) {
        this.game = game;
        this.actionDispatcher = game.getActionDispatcher();
        number = i;
        name = Integer.toString(number);
        occupants = new LinkedHashSet<>();
    }

    @Override
    public void onLand(OnMoveEvent event) {
        if (game.isPrankster() && this.occupants.size() > 0) {
            Player occupant = this.occupants.iterator().next();
            OnPrankEvent prank = game.getActionBuilder().getPrankEvent(occupant);
            actionDispatcher.dispatchEvent(prank);
        }
        this.addOccupant(event.getPlayer());
	}
	
	protected void addOccupant(Player p) {
        this.occupants.add(p);
        p.setPosition(this);
    }

    public void removeOccupant(Player p) {
        this.occupants.remove(p);
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