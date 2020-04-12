package it.matteoavanzini.game.goose.tile;

import java.util.Set;

import it.matteoavanzini.game.goose.event.OnMoveEvent;
import it.matteoavanzini.game.goose.model.Player;

public interface Tile {
    int getNumber();
    String getName();
    Set<Player> getOccupants();
    void removeOccupant(Player p);
    void onLand(OnMoveEvent event);
}