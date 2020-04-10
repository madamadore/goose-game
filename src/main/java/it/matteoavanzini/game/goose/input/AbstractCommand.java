package it.matteoavanzini.game.goose.input;

import java.util.regex.Pattern;

import it.matteoavanzini.game.goose.GameBoard;

public abstract class AbstractCommand implements Command {

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