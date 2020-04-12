package it.matteoavanzini.game.goose.action;

public class ActionResult {
    private boolean success;
    private String message = "";

    public ActionResult(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

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

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public boolean isSuccess() {
        return success;
    }
}