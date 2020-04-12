package it.matteoavanzini.game.goose.event;

public interface ActionDispatcher {
    void dispatchEvent(ActionEvent action);
    void registerListener(ActionListener listener);
    void unregisterListener(ActionListener listener);
    ActionBuilder getActionBuilder();
}