package it.matteoavanzini.game.goose.action;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import it.matteoavanzini.game.goose.GooseGameTest;
import it.matteoavanzini.game.goose.exception.InvalidActionException;

public class AddPlayerActionTest extends GooseGameTest {

    @Test
    public void addPlayer() throws InvalidActionException {
        AddPlayerAction action = new AddPlayerAction(game, "Pippo");
        ActionResult result = action.execute();
        assertEquals("players: Pippo", result.getMessage());

        action = new AddPlayerAction(game, "Pluto");
        result = action.execute();
        assertEquals("players: Pippo, Pluto", result.getMessage());
    }
}