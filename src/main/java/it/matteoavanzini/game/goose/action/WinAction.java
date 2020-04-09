package it.matteoavanzini.game.goose.action;

import java.util.ArrayList;
import java.util.List;

import it.matteoavanzini.game.goose.GameBoard;
import it.matteoavanzini.game.goose.exception.InvalidActionException;
import it.matteoavanzini.game.goose.model.DiceRoll;
import it.matteoavanzini.game.goose.model.Player;
import it.matteoavanzini.game.goose.tile.Tile;

public class WinAction extends AbstractAction {

    private Player player;
    
    public WinAction(Player player, int... rollDice) {
        this.player = player;
        this.message = "%s Wins!!";
    }

    @Override
    public ActionResult execute() throws InvalidActionException {

        List<Object> messageParameters = new ArrayList<>();
        GameBoard game = player.getGame();
        Tile currentPlayerPosition = player.getPosition();
        if (currentPlayerPosition.equals(game.getFinalTile())) {

            game.endGame();

            messageParameters.add(player.getName());
            return buildResult(messageParameters);
        }
        return null;
    }

}