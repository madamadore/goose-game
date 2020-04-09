package it.matteoavanzini.game.goose.input;

import it.matteoavanzini.game.goose.action.Action;
import it.matteoavanzini.game.goose.exception.InvalidCommandException;

public interface CommandParserInterface {
    boolean isValid(String command); 
    Action parse(String command) throws InvalidCommandException;
}