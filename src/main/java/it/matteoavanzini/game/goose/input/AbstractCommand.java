package it.matteoavanzini.game.goose.input;

import java.util.regex.Pattern;

import it.matteoavanzini.game.goose.GameBoard;
import it.matteoavanzini.game.goose.action.Action;

public abstract class AbstractCommand<T extends Action> implements Command<T> {

    protected GameBoard game;
    protected Pattern pattern;

    AbstractCommand(GameBoard game) {
        this.game = game;
    }

    @Override
    public Pattern getPattern() {
        return pattern;
    }
}