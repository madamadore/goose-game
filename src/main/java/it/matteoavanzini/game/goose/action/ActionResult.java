package it.matteoavanzini.game.goose.action;

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
    private String message = "";

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