package it.matteoavanzini.game.goose.input;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import it.matteoavanzini.game.goose.GameContext;
import it.matteoavanzini.game.goose.event.ActionBuilder;
import it.matteoavanzini.game.goose.event.OnAddPlayerEvent;

public class AddPlayerCommand extends AbstractCommand<OnAddPlayerEvent> {

    public AddPlayerCommand(GameContext game) {
        super(game);
        this.pattern = Pattern.compile("^(add player) (\\w*)$");
    }

    public OnAddPlayerEvent getAction(String input) {
        Matcher m = pattern.matcher(input);
        if (m.find()) {
            String playerName = m.group(2);
            ActionBuilder actionBuilder = game.getActionBuilder();
            return actionBuilder.getAddPlayerEvent(playerName);
        }
        return null;
    }

}