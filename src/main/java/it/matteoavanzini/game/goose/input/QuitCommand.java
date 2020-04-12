package it.matteoavanzini.game.goose.input;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import it.matteoavanzini.game.goose.GameBoard;
import it.matteoavanzini.game.goose.action.QuitAction;

public class QuitCommand extends AbstractCommand<QuitAction> {

    public QuitCommand(GameBoard game) {
        super(game);
        this.pattern = Pattern.compile("^quit$");
    }

    public QuitAction getAction(String input) {
        Matcher m = pattern.matcher(input);
        if (m.find()) {
            return new QuitAction(game);
        }
        return null;
    }

}