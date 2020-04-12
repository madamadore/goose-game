package it.matteoavanzini.game.goose.action;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import it.matteoavanzini.game.goose.GooseGameTest;
import it.matteoavanzini.game.goose.exception.DuplicateUserException;
import it.matteoavanzini.game.goose.model.GoosePlayer;
import it.matteoavanzini.game.goose.model.Player;

public class DuplicatedPlayerActionTest extends GooseGameTest {

    @Rule
    public ExpectedException duplicateUserException = ExpectedException.none();

    @Before
    public void setUp() {
        Player pippo = new GoosePlayer(game, "Pippo");
        game.addParticipant(pippo);
    }
    
    @Test
    public void shouldThrowExceptionWhenDuplicateUser() throws Exception {
        duplicateUserException.expect(DuplicateUserException.class);
        duplicateUserException.expectMessage("Pippo: already existing player");

        AddPlayerAction action = new AddPlayerAction(game, "Pippo");
        action.execute();
    }
}