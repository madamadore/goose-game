package it.matteoavanzini.game.goose.input;

import it.matteoavanzini.game.goose.event.ActionEvent;
import it.matteoavanzini.game.goose.exception.ParseCommandException;

public interface CommandParserInterface {
    ActionEvent parse(String command) throws ParseCommandException;
}