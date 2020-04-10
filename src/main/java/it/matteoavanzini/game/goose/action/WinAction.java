package it.matteoavanzini.game.goose.action;

import it.matteoavanzini.game.goose.GameBoard;
import it.matteoavanzini.game.goose.exception.InvalidActionException;
import it.matteoavanzini.game.goose.model.Player;

public class WinAction extends AbstractAction {

    private Player player;
    private GameBoard game;

    public WinAction(Player player) {
        this.player = player;
        this.game = player.getGame();
        this.message = "%s Wins!!";
    }

    @Override
    public boolean executeAction() throws InvalidActionException {
        game.endGame();
        return true;
    }

    @Override
    public Object[] getMessageParameters() {
        return new Object[] {
            player.getName()
        };
    }
}