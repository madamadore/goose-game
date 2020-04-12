package it.matteoavanzini.game.goose.input;

import static org.junit.Assert.assertEquals;

import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import it.matteoavanzini.game.goose.GooseGameTest;
import it.matteoavanzini.game.goose.action.Action;
import it.matteoavanzini.game.goose.action.MoveAction;
import it.matteoavanzini.game.goose.exception.InvalidCommandException;
import it.matteoavanzini.game.goose.exception.ParseCommandException;
import it.matteoavanzini.game.goose.model.GoosePlayer;
import it.matteoavanzini.game.goose.model.Player;

public class CommandParserTest extends GooseGameTest {

    private CommandParserInterface parser;

    @Before
    public void setUp() {
        Set<Command<? extends Action>> commands = new HashSet<Command<? extends Action>>();
        commands.add(new AddPlayerCommand(game));
        commands.add(new MoveCommand(game));

        parser = new CommandParser(commands);
        Player pippo = new GoosePlayer(game, "Pippo");
        game.getPlayers().add(pippo);
    }

    @Test
    public void testValidCommands() throws InvalidCommandException {
        Action move = parser.parse("move Pippo 4, 2");
        assertEquals(MoveAction.class, move.getClass());
    }

    @Test(expected = ParseCommandException.class)
    public void invalidParseDigit() throws InvalidCommandException {
        parser.parse("move Pippo 40, 20");
    }

    @Test(expected = ParseCommandException.class)
    public void invalidMoveCommand() throws InvalidCommandException {
        parser.parse("move");
    }

    @Test(expected = ParseCommandException.class)
    public void genericInvalidCommand() throws InvalidCommandException {
        parser.parse("honkey donkey");
    }
}