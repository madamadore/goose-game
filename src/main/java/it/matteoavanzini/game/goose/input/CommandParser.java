package it.matteoavanzini.game.goose.input;

import java.util.Set;

import it.matteoavanzini.game.goose.action.Action;
import it.matteoavanzini.game.goose.exception.ParseCommandException;

public class CommandParser implements CommandParserInterface {

    private Set<Command<? extends Action>> commands;

    public CommandParser(Set<Command<? extends Action>> commands) {
        this.commands = commands;
    }

    public Action parse(String input) throws ParseCommandException {
        for (Command<? extends Action> command : commands) {
            if (input.matches(command.getPattern().pattern())) {
                return command.getAction(input);
            }
        }
        throw new ParseCommandException("invalid command");
    }

     



    

}