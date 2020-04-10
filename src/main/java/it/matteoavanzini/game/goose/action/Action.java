package it.matteoavanzini.game.goose.action;

import it.matteoavanzini.game.goose.exception.InvalidActionException;

public interface Action {
    Object[] getMessageParameters();
    ActionResult execute() throws InvalidActionException;
}