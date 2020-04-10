package it.matteoavanzini.game.goose.input;

import java.util.regex.Pattern;

import it.matteoavanzini.game.goose.action.Action;
import it.matteoavanzini.game.goose.exception.ParseCommandException;

public interface Command {
    Pattern getPattern();
    Action getAction(String input) throws ParseCommandException;
}