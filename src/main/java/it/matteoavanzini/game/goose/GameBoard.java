package it.matteoavanzini.game.goose;

import java.util.List;

import it.matteoavanzini.game.goose.action.Action;
import it.matteoavanzini.game.goose.action.ActionBuilder;
import it.matteoavanzini.game.goose.action.ActionResult;
import it.matteoavanzini.game.goose.model.DiceRoll;
import it.matteoavanzini.game.goose.model.Player;
import it.matteoavanzini.game.goose.tile.Tile;

public interface GameBoard {
    final static boolean PRANKSTER = true;
    
    DiceRoll getDiceRoll();
    DiceRoll rollDice();
    boolean isPrankster();
    boolean isRunning();
    List<Tile> getTiles();
    List<Player> getPlayers();
    void endGame();
    void start();
    Tile getTile(int number);
    Tile getStartingTile();
    Tile getFinalTile();
    Player getPlayer(String name);
    void addParticipant(Player player);
    ActionBuilder getActionBuilder();
    void dispatchAction(Action action);
    ActionResult getActionResult();
}