package it.matteoavanzini.game.goose.event;

public interface ActionEvent {
    ActionListener getTarget();
    String getMessage();
    void setMessage(String message);
}