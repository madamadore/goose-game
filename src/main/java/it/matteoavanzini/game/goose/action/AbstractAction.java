package it.matteoavanzini.game.goose.action;

import java.util.List;
import java.util.Locale;

import it.matteoavanzini.game.goose.exception.GooseException;
import lombok.Getter;

public abstract class AbstractAction implements Action {
    @Getter
    protected String message;

    protected ActionResult merge(ActionResult... subResults) {
        boolean success = true;
        GooseException exception = null;
        if (subResults.length > 0) {
            for (ActionResult result : subResults) {
                if (null != result) {
                    if (result.isSuccess()) {
                        this.message += ". " + result.getMessage();
                    } else {
                        success = false;
                        this.message = result.getMessage();
                        break;
                    }
                }
            }
        }
        return new ActionResult(success, this.message, exception);
    }

    protected String formatMessage(List<Object> messageParameters) {
        Object[] args = new Object[0];
        if (null != messageParameters) {
            args = new Object[messageParameters.size()]; 
            args = messageParameters.toArray(args);
        }
        Locale locale = Locale.getDefault();
        return String.format(locale, this.message, args);
    }

    protected ActionResult buildResult(List<Object> messageParameters, ActionResult... actionTail) {    
        this.message = formatMessage(messageParameters);
		return merge(actionTail);
    }
}