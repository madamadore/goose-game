package it.matteoavanzini.game.goose.input;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import it.matteoavanzini.game.goose.GameContext;
import it.matteoavanzini.game.goose.event.ActionBuilder;
import it.matteoavanzini.game.goose.event.OnMoveEvent;
import it.matteoavanzini.game.goose.exception.ParseCommandException;
import it.matteoavanzini.game.goose.model.Player;

public class MoveCommand extends AbstractCommand<OnMoveEvent> {

    public MoveCommand(GameContext game) {
        super(game);
        this.pattern = Pattern.compile("^(move) (\\w*) *(\\d, \\d)?$");
    }

    public OnMoveEvent getAction(String input) throws ParseCommandException {
        Matcher m = pattern.matcher(input);
        if (m.find()) {
            String playerName = m.group(2);
            Player player = game.getPlayer(playerName);

            if (null == player) {
                throw new ParseCommandException(playerName + ": unknown player");
            }

            int[] roll = new int[0];
            String rollDice = m.group(3);
            if (null != rollDice) {
                roll = parseRollDice(rollDice);
            }
        
            player.getDiceRoll().setRoll(roll);
            ActionBuilder actionBuilder = game.getActionBuilder();
            return actionBuilder.getMoveEvent(player);
        } 
        return null;
    }

    private int[] parseRollDice(String rollDice) {
        String[] temp = rollDice.split(",");
        int[] result = new int[temp.length];
        for (int i=0; i<temp.length; i++) {
            result[i] = Integer.parseInt(temp[i].trim());
        }
        return result;
    }
}