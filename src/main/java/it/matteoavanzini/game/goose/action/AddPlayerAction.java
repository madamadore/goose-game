package it.matteoavanzini.game.goose.action;

import java.util.List;

import it.matteoavanzini.game.goose.GameBoard;
import it.matteoavanzini.game.goose.exception.DuplicateUserException;
import it.matteoavanzini.game.goose.exception.InvalidActionException;
import it.matteoavanzini.game.goose.model.GoosePlayer;
import it.matteoavanzini.game.goose.model.Player;
import it.matteoavanzini.game.goose.tile.Tile;

public class AddPlayerAction extends AbstractAction {

    private GameBoard game;
    private String newPlayerName;

    public String getMessage() {
        return "players: ";
    }

    public AddPlayerAction(GameBoard game, String name) {
        this.game = game;
        this.newPlayerName = name;
    }

    private String getSuccessMessage(List<Player> players) {
        String message = getMessage();
        for (Player p : players) {
            message += p.getName() + ", ";
        }
        return message.substring(0, message.length() - 2);
    }

    @Override
    public ActionResult execute() throws InvalidActionException {

        ActionResult result = new ActionResult();
        Tile startTile = game.getStartingTile();
        List<Player> playersOnGame = game.getPlayers();
        Player temporaryPlayer = new GoosePlayer(startTile, newPlayerName, game);
        if (!playersOnGame.contains(temporaryPlayer)) {
            
            game.addParticipant(temporaryPlayer);
            String message = getSuccessMessage(playersOnGame);

            result.setSuccess(true);
            result.setMessage(message);
        } else {
            throw new DuplicateUserException(newPlayerName);
        }
        return result;
    }

}