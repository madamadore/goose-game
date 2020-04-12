package it.matteoavanzini.game.goose.event;

public interface OnBounceActionListener extends OnMoveActionListener {
    void onBounce(OnBounceEvent event);
}