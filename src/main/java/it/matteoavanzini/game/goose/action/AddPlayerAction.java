package it.matteoavanzini.game.goose.action;

import java.util.List;

import it.matteoavanzini.game.goose.GameBoard;
import it.matteoavanzini.game.goose.exception.DuplicateUserException;
import it.matteoavanzini.game.goose.exception.InvalidActionException;
import it.matteoavanzini.game.goose.model.GoosePlayer;
import it.matteoavanzini.game.goose.model.Player;

public class AddPlayerAction extends AbstractAction {

    private GameBoard game;
    private String newPlayerName;

    public AddPlayerAction(GameBoard game, String name) {
        this.game = game;
        this.newPlayerName = name;
        this.message = "players: %s";
    }

    @Override
    public boolean executeAction() throws InvalidActionException {

        List<Player> playersOnGame = game.getPlayers();
        Player temporaryPlayer = new GoosePlayer(game, newPlayerName);
        
        if (!playersOnGame.contains(temporaryPlayer)) {
            game.addParticipant(temporaryPlayer);
        } else {
            throw new DuplicateUserException(newPlayerName);
        }
        return true;
    }

    @Override
    public Object[] getMessageParameters() {
        String message = "";
        List<Player> players = game.getPlayers();
        for (Player p : players) {
            message += p.getName() + ", ";
        }
        message = message.substring(0, message.length() - 2);
        return new Object[] { message };
    }

}