package it.matteoavanzini.game.goose.exception;

public class DuplicateUserException extends InvalidActionException {
    public DuplicateUserException(String playerName) {
        super(playerName + ": already existing player");
    }
}