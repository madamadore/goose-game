package it.matteoavanzini.game.goose.input;

import java.util.regex.Pattern;

import it.matteoavanzini.game.goose.event.ActionEvent;
import it.matteoavanzini.game.goose.exception.ParseCommandException;

public interface Command<T extends ActionEvent> {
    Pattern getPattern();
    T getAction(String input) throws ParseCommandException;
}