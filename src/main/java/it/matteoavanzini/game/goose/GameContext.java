package it.matteoavanzini.game.goose;

import java.util.Set;

import it.matteoavanzini.game.goose.event.ActionBuilder;
import it.matteoavanzini.game.goose.event.ActionDispatcher;
import it.matteoavanzini.game.goose.model.DiceRoll;
import it.matteoavanzini.game.goose.model.Player;
import it.matteoavanzini.game.goose.tile.Tile;

public interface GameContext {
    final static boolean PRANKSTER = true;

    ActionDispatcher getActionDispatcher();
    ActionBuilder getActionBuilder();
    DiceRoll getDiceRoll();
    boolean isPrankster();
    void endGame();
    void start();
    int getTilesCount();
    Tile getTile(int number);
    Player getPlayer(String name);
    void addParticipant(Player player);
    Set<Player> getPlayers();
}