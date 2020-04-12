package it.matteoavanzini.game.goose.event;

import java.util.Set;

import it.matteoavanzini.game.goose.GameContext;
import it.matteoavanzini.game.goose.model.GoosePlayer;
import it.matteoavanzini.game.goose.model.Player;
import lombok.Getter;

public class OnAddPlayerEvent extends AbstractActionEvent {

    @Getter
    private Player player;
    private GameContext game;

    public OnAddPlayerEvent(GameContext game, String name) {
        this.game = game;
        player = new GoosePlayer(game, name);
    }

    @Override
    public Object[] getMessageParameters() {
        String message = "";
        Set<Player> players = game.getPlayers();
        for (Player p : players) {
            message += p.getName() + ", ";
        }
        message = message.substring(0, message.length() - 2);
        return new Object[] { message };
    }
}