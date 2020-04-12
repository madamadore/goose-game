package it.matteoavanzini.game.goose.action;

import java.util.Locale;

import it.matteoavanzini.game.goose.exception.InvalidActionException;

public abstract class AbstractAction implements Action {
    
    protected String message;

    protected abstract boolean executeAction() throws InvalidActionException;

    protected String formatMessage(Object[]  messageParameters) {
        Locale locale = Locale.getDefault();
        return String.format(locale, this.message, messageParameters);
    }

    public ActionResult execute() throws InvalidActionException {
        boolean success = executeAction();
        Object[] messageParameters = getMessageParameters();
        String message = formatMessage(messageParameters);
        return new ActionResult(success, message);
    }

    protected String getMessage() {
        return message;
    }
}