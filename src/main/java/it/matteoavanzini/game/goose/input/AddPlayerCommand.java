package it.matteoavanzini.game.goose.input;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import it.matteoavanzini.game.goose.GameBoard;
import it.matteoavanzini.game.goose.action.AddPlayerAction;

public class AddPlayerCommand extends AbstractCommand<AddPlayerAction> {

    public AddPlayerCommand(GameBoard game) {
        super(game);
        this.pattern = Pattern.compile("^(add player) (\\w*)$");
    }

    public AddPlayerAction getAction(String input) {
        Matcher m = pattern.matcher(input);
        if (m.find()) {
            String playerName = m.group(2);
            return new AddPlayerAction(game, playerName);
        }
        return null;
    }

}