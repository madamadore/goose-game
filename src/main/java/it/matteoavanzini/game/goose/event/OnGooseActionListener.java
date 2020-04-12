package it.matteoavanzini.game.goose.event;

public interface OnGooseActionListener extends OnMoveActionListener {
    void onGoose(OnGooseEvent event);
}