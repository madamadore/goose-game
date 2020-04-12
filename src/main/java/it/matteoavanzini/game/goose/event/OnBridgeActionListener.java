package it.matteoavanzini.game.goose.event;

public interface OnBridgeActionListener extends OnMoveActionListener {
    void onBridge(OnBridgeEvent event);
}