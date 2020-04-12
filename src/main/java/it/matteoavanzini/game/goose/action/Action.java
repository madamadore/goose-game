package it.matteoavanzini.game.goose.action;

import it.matteoavanzini.game.goose.event.ActionEvent;

public interface Action<T extends ActionEvent> {
    T prepareEvent();
}