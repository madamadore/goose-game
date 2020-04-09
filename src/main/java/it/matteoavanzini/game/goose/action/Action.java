package it.matteoavanzini.game.goose.action;

import it.matteoavanzini.game.goose.exception.InvalidActionException;

public interface Action {
    String getMessage();
    ActionResult execute() throws InvalidActionException;
}