package it.matteoavanzini.game.goose.input;

import java.util.Set;
import java.util.regex.Pattern;

import it.matteoavanzini.game.goose.event.ActionEvent;
import it.matteoavanzini.game.goose.exception.ParseCommandException;

public class CommandParser implements CommandParserInterface {

    private Set<Command<? extends ActionEvent>> commands;

    public CommandParser(Set<Command<? extends ActionEvent>> commands) {
        this.commands = commands;
    }

    public boolean isValid(String input) {
        boolean valid = false;
        for (Command<? extends ActionEvent> command : commands) {
            valid = Pattern.matches(command.getPattern().pattern(), input);
            if (valid) break;
        }
        return valid;
    }

    public ActionEvent parse(String input) throws ParseCommandException {
        for (Command<? extends ActionEvent> command : commands) {
            if (input.matches(command.getPattern().pattern())) {
                return command.getAction(input);
            }
        }
        throw new ParseCommandException("invalid command");
    }

     



    

}