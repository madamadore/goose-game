package it.matteoavanzini.game.goose.input;

import java.util.regex.Pattern;

import it.matteoavanzini.game.goose.GameContext;
import it.matteoavanzini.game.goose.event.ActionEvent;

public abstract class AbstractCommand<T extends ActionEvent> implements Command<T> {

    protected GameContext game;
    protected Pattern pattern;

    AbstractCommand(GameContext game) {
        this.game = game;
    }

    @Override
    public Pattern getPattern() {
        return pattern;
    }
}