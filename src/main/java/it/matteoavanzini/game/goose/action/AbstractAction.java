package it.matteoavanzini.game.goose.action;

import java.util.Locale;

import it.matteoavanzini.game.goose.event.ActionEvent;
import lombok.Getter;

public abstract class AbstractAction<T extends ActionEvent> implements Action<T> {
    @Getter
    protected String message;

    protected abstract Object[] getMessageParameters();
    protected abstract T getEvent();

    protected String formatMessage(Object[]  messageParameters) {
        Locale locale = Locale.getDefault();
        return String.format(locale, this.message, messageParameters);
    }

    public T prepareEvent() {
        T event = getEvent();
        Object[] messageParameters = getMessageParameters();
        String message = formatMessage(messageParameters);
        event.setMessage(message);
        return event;
    }
}