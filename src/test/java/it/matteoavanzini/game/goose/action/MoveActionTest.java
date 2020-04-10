package it.matteoavanzini.game.goose.action;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import it.matteoavanzini.game.goose.GooseGameTest;
import it.matteoavanzini.game.goose.exception.InvalidActionException;
import it.matteoavanzini.game.goose.model.GoosePlayer;
import it.matteoavanzini.game.goose.model.Player;
import it.matteoavanzini.game.goose.tile.SimpleTile;

public class MoveActionTest extends GooseGameTest {

    private Player pippo;
    private Player pluto;

    @Before
    public void setUp() throws InvalidActionException {
        pippo = new GoosePlayer(game.getStartingTile(), "Pippo", game);
        pluto = new GoosePlayer(game.getStartingTile(), "Pluto", game);
        game.getTiles().remove(6);
        game.getTiles().add(6, new SimpleTile(game, 6));
    }

    @Test
    public void testMovePippo() throws InvalidActionException {
        MoveAction action = new MoveAction(pippo, 4, 2);
        game.dispatchAction(action);
        ActionResult result = game.getActionResult();
        assertEquals("Pippo rolls 4, 2. Pippo moves from Start to 6", result.getMessage());
    }

    @Test
    public void testMovePluto() throws InvalidActionException {
        MoveAction action = new MoveAction(pluto, 2, 2);
        game.dispatchAction(action);
        ActionResult result = game.getActionResult();
        assertEquals("Pluto rolls 2, 2. Pluto moves from Start to 4", result.getMessage());
    }

    @Test
    public void testMovePippoAgain() throws InvalidActionException {
        pippo.moveTo(game.getTile(6));
        MoveAction action = new MoveAction(pippo, 3, 2);
        game.dispatchAction(action);
        ActionResult result = game.getActionResult();
        assertEquals("Pippo rolls 3, 2. Pippo moves from 6 to 11", result.getMessage());
    }
}