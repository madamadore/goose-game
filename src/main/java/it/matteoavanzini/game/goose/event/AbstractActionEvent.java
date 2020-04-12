package it.matteoavanzini.game.goose.event;

import java.util.Locale;

import lombok.Getter;
import lombok.Setter;

public abstract class AbstractActionEvent implements ActionEvent {

    protected String message;
    @Getter @Setter
    private ActionListener target;
    protected abstract Object[] getMessageParameters();

    protected String formatMessage() {
        Locale locale = Locale.getDefault();
        Object[] messageParameters = getMessageParameters();
        return String.format(locale, this.message, messageParameters);
    }

    @Override
    public String getMessage() {
        return this.message;
    }

    @Override
    public void setMessage(String message) {
        this.message = message;
    }

}