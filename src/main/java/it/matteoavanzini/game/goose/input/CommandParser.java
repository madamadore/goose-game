package it.matteoavanzini.game.goose.input;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import it.matteoavanzini.game.goose.GameBoard;
import it.matteoavanzini.game.goose.action.Action;
import it.matteoavanzini.game.goose.action.ActionBuilder;
import it.matteoavanzini.game.goose.exception.InvalidCommandException;
import it.matteoavanzini.game.goose.exception.ParseCommandException;
import it.matteoavanzini.game.goose.model.Player;

public class CommandParser implements CommandParserInterface {

    private GameBoard game;
    private Pattern movePattern = Pattern.compile("^(move) (\\w*) *(\\d, \\d)?$");
    private Pattern addPlayerPattern = Pattern.compile("^(add player) (\\w*)$");

    public CommandParser(GameBoard game) {
        this.game = game;
    }

    public boolean isValid(String input) {
        return Pattern.matches(movePattern.pattern(), input) || 
            Pattern.matches(addPlayerPattern.pattern(), input);
    }

    public Action parse(String command) throws InvalidCommandException {
        if (isValid(command)) {
            if (command.matches(movePattern.pattern())) {
                return parseMoveAction(command);
            } else if (command.matches(addPlayerPattern.pattern())) {
                return parseAddPlayerAction(command);
            } 
        }
        throw new ParseCommandException("invalid command");
    }

    private Action parseMoveAction(String command) throws InvalidCommandException {
        Matcher m = movePattern.matcher(command);
        if (m.find()) {
            String playerName = m.group(2);
            Player player = game.getPlayer(playerName);

            if (null == player) {
                throw new InvalidCommandException(playerName + ": unknown player");
            }

            int[] roll = new int[0];
            String rollDice = m.group(3);
            if (null != rollDice) {
                roll = parseRollDice(rollDice);
            }
        
            ActionBuilder actionBuilder = game.getActionBuilder();
            return actionBuilder.getMoveAction(player, roll);
        } 
        return null;
    } 

    private Action parseAddPlayerAction(String command) {
        Matcher m = addPlayerPattern.matcher(command);
        if (m.find()) {
            String playerName = m.group(2);
            ActionBuilder actionBuilder = game.getActionBuilder();
            return actionBuilder.getAddPlayerAction(game, playerName);
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