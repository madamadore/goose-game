package it.matteoavanzini.game.goose.action;

import it.matteoavanzini.game.goose.exception.GooseException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ActionResult {
    private boolean success;
    private String message;
    private GooseException exception;
}