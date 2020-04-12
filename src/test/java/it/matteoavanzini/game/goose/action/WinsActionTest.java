package it.matteoavanzini.game.goose.action;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import it.matteoavanzini.game.goose.GooseGameTest;
import it.matteoavanzini.game.goose.exception.InvalidActionException;
import it.matteoavanzini.game.goose.model.GoosePlayer;
import it.matteoavanzini.game.goose.model.Player;

public class WinsActionTest extends GooseGameTest {

    private Player pippo;

    @Before
    public void setUp() throws InvalidActionException {
        pippo = new GoosePlayer(game, "Pippo");
        game.getTile(60).onLand(pippo);
    }

    @Test
    public void testBounce() throws InvalidActionException {
        MoveAction action = new MoveAction(pippo, 3, 2);
        game.dispatchAction(action);
        ActionResult result = game.getActionResult();
        assertEquals("Pippo rolls 3, 2. Pippo moves from 60 to 63. Pippo bounces! Pippo returns to 61", result.getMessage());
    }

    @Test
    public void testWin() throws InvalidActionException {
        game.getTile(60).onLand(pippo);
        MoveAction action = new MoveAction(pippo, 1, 2);
        game.dispatchAction(action);
        ActionResult result = game.getActionResult();
        assertEquals("Pippo rolls 1, 2. Pippo moves from 60 to 63. Pippo Wins!!", result.getMessage());
    }
}