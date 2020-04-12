package it.matteoavanzini.game.goose.input;

import it.matteoavanzini.game.goose.action.Action;
import it.matteoavanzini.game.goose.exception.InvalidCommandException;

public interface CommandParserInterface {
    Action parse(String command) throws InvalidCommandException;
}