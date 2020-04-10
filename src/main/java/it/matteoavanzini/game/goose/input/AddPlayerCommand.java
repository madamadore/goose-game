package it.matteoavanzini.game.goose.input;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import it.matteoavanzini.game.goose.GameBoard;
import it.matteoavanzini.game.goose.action.Action;
import it.matteoavanzini.game.goose.action.ActionBuilder;

public class AddPlayerCommand extends AbstractCommand {

    public AddPlayerCommand(GameBoard game) {
        super(game);
        this.pattern = Pattern.compile("^(add player) (\\w*)$");
    }

    public Action getAction(String input) {
        Matcher m = pattern.matcher(input);
        if (m.find()) {
            String playerName = m.group(2);
            ActionBuilder actionBuilder = game.getActionBuilder();
            return actionBuilder.getAddPlayerAction(game, playerName);
        }
        return null;
    }

}