package it.matteoavanzini.game.goose.action;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import it.matteoavanzini.game.goose.GooseGameTest;
import it.matteoavanzini.game.goose.exception.InvalidActionException;
import it.matteoavanzini.game.goose.model.GoosePlayer;
import it.matteoavanzini.game.goose.model.Player;

public class AddPlayerActionTest extends GooseGameTest {

    @Test
    public void addPlayer() throws InvalidActionException {
        AddPlayerAction action = new AddPlayerAction(game, "Pippo");
        game.dispatchAction(action);
        ActionResult result = game.getActionResult();
        assertEquals("players: Pippo", result.getMessage());
    }

    @Test
    public void addSecondPlayer() throws InvalidActionException {
        Player pippo = new GoosePlayer(game.getStartingTile(), "Pippo", game);
        game.addParticipant(pippo);
        
        Action action = new AddPlayerAction(game, "Pluto");
        game.dispatchAction(action);
        ActionResult result = game.getActionResult();
        assertEquals("players: Pippo, Pluto", result.getMessage());
    }
}