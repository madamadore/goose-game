package it.matteoavanzini.game.goose.action;

import it.matteoavanzini.game.goose.event.OnAddPlayerEvent;

public class AddPlayerAction extends AbstractAction<OnAddPlayerEvent> {

    public AddPlayerAction() {
        this.message = "players: %s";
    }

    @Override
    protected OnAddPlayerEvent getEvent() {

        return new OnAddPlayerEvent(null);
    }

    public Object[] getMessageParameters() { return null; }
    // @Override
    // public Object[] getMessageParameters() {
    //     String message = "";
    //     List<Player> players = game.getPlayers();
    //     for (Player p : players) {
    //         message += p.getName() + ", ";
    //     }
    //     message = message.substring(0, message.length() - 2);
    //     return new Object[] { message };
    // }

}