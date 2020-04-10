package it.matteoavanzini.game.goose.input;

import java.util.Set;
import java.util.regex.Pattern;

import it.matteoavanzini.game.goose.GameBoard;
import it.matteoavanzini.game.goose.action.Action;
import it.matteoavanzini.game.goose.exception.ParseCommandException;

public class CommandParser implements CommandParserInterface {

    private GameBoard game;
    private Set<Command> commands;

    public CommandParser(GameBoard game, Set<Command> commands) {
        this.game = game;
        this.commands = commands;
    }

    public boolean isValid(String input) {
        boolean valid = false;
        for (Command command : commands) {
            valid = Pattern.matches(command.getPattern().pattern(), input);
            if (valid) break;
        }
        return valid;
    }

    public Action parse(String input) throws ParseCommandException {
        if (isValid(input)) {
            for (Command command : commands) {
                if (input.matches(command.getPattern().pattern())) {
                    return command.getAction(input);
                }
            }
        }
        throw new ParseCommandException("invalid command");
    }

     



    

}