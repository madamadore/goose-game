package it.matteoavanzini.game.goose.action;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import it.matteoavanzini.game.goose.GameBoard;
import it.matteoavanzini.game.goose.GooseGameBoard;
import it.matteoavanzini.game.goose.GooseGameTest;
import it.matteoavanzini.game.goose.exception.GooseException;
import it.matteoavanzini.game.goose.exception.InvalidActionException;
import it.matteoavanzini.game.goose.model.GoosePlayer;
import it.matteoavanzini.game.goose.model.Player;

public class PrankActionTest extends GooseGameTest {

    private Player pippo;
    private Player pluto;

    @Before
    public void setUp() throws InvalidActionException {
        game = new GooseGameBoard(GameBoard.PRANKSTER);
        pippo = new GoosePlayer(game, "Pippo");
        pluto = new GoosePlayer(game, "Pluto");
        game.addParticipant(pippo);
        game.addParticipant(pluto);

        pippo.moveTo(game.getTile(15));
        pluto.moveTo(game.getTile(17));
    }

    @Test
    public void testPrank() throws GooseException {
        ((GooseGameBoard) game).executeCommand("move Pippo 1, 1");
        ActionResult result = game.getActionResult();
        assertEquals("Pippo rolls 1, 1. Pippo moves from 15 to 17. On 17 there is Pluto, who returns to 15", result.getMessage());
    }

    @Test
    public void testPrankOnBridge() throws GooseException {
        pippo.moveTo(game.getTile(3));
        pluto.moveTo(game.getTile(12));
        
        ((GooseGameBoard) game).executeCommand("move Pippo 2, 1");
        ActionResult result = game.getActionResult();
        assertEquals("Pippo rolls 2, 1. Pippo moves from 3 to The Bridge. Pippo jumps to 12. On 12 there is Pluto, who returns to The Bridge", result.getMessage());
    }

}