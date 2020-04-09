package it.matteoavanzini.game.goose.exception;

public class InvalidCommandException extends GooseException {
    public InvalidCommandException(String message) {
        super(message);
    }
}