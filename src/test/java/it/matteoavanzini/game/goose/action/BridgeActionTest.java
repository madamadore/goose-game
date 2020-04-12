package it.matteoavanzini.game.goose.action;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import it.matteoavanzini.game.goose.GooseGameTest;
import it.matteoavanzini.game.goose.exception.InvalidActionException;
import it.matteoavanzini.game.goose.model.GoosePlayer;
import it.matteoavanzini.game.goose.model.Player;

public class BridgeActionTest extends GooseGameTest {

    private Player pippo;

    @Before
    public void setUp() throws InvalidActionException {
        pippo = new GoosePlayer(game, "Pippo");
        game.getTile(4).onLand(pippo);
    }

    @Test
    public void testBridge() throws InvalidActionException {
        MoveAction action = new MoveAction(pippo, 1, 1);
        game.dispatchAction(action);
        ActionResult result = game.getActionResult();
        assertEquals("Pippo rolls 1, 1. Pippo moves from 4 to The Bridge. Pippo jumps to 12", result.getMessage());
    }
}