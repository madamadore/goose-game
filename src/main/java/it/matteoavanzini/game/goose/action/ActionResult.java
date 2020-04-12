package it.matteoavanzini.game.goose.action;

import it.matteoavanzini.game.goose.event.ActionEvent;
import lombok.Getter;

public abstract class ActionResult implements ActionEvent {
    @Getter
    protected boolean success;
    protected String message = "";

    public ActionResult merge(ActionResult... results) {
        boolean success = true;
        if (results.length > 0) {
            for (ActionResult result : results) {
                if (null != result) {
                    if (result.isSuccess()) {
                        this.message += ". " + result.getMessage();
                    } else {
                        success = false;
                        this.message = result.getMessage();
                        break;
                    }
                }
            }
        }
        return new ActionResult(success, this.message);
    }
}