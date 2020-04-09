package it.matteoavanzini.game.goose.action;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import it.matteoavanzini.game.goose.GooseGameTest;
import it.matteoavanzini.game.goose.exception.InvalidActionException;
import it.matteoavanzini.game.goose.model.GoosePlayer;
import it.matteoavanzini.game.goose.model.Player;

public class GooseActionTest extends GooseGameTest {

    private Player pippo;

    @Before
    public void setUp() throws InvalidActionException {
        pippo = new GoosePlayer(game.getStartingTile(), "Pippo", game);
        game.getTile(3).onLand(pippo);
    }

    @Test
    public void testGoose() throws InvalidActionException {
        MoveAction action = new MoveAction(pippo, 1, 1);
        ActionResult result = action.execute();
        assertEquals("Pippo rolls 1, 1. Pippo moves from 3 to 5, The Goose. Pippo moves again and goes to 7", result.getMessage());
    }

    @Test
    public void testMultipleGoose() throws InvalidActionException {
        game.getTile(10).onLand(pippo);
        MoveAction action = new MoveAction(pippo, 2, 2);
        ActionResult result = action.execute();
        assertEquals("Pippo rolls 2, 2. Pippo moves from 10 to 14, The Goose. Pippo moves again and goes to 18, The Goose. Pippo moves again and goes to 22", result.getMessage());
    }
}