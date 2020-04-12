package it.matteoavanzini.game.goose.action;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import it.matteoavanzini.game.goose.GameBoard;
import it.matteoavanzini.game.goose.exception.InvalidActionException;

public class QuitAction extends AbstractAction {
    
    protected GameBoard game;

    public QuitAction(GameBoard game) {
        this.game = game;
        this.message = "Thank you for playing! Goodbye!";
    }

    @Override
    public boolean executeAction() throws InvalidActionException {
        // don't close BufferedReader to preserve System.in
        BufferedReader bf = null;
        System.out.print("Game is not ended. Are you sure? [no] ");
        try {
            bf = new BufferedReader(new InputStreamReader(System.in));
            String response = bf.readLine();
            if (response.equalsIgnoreCase("Y") || response.equalsIgnoreCase("yes")) {
                game.endGame();
                return true;
            }
        } catch (IOException ignore) {} 
        return false;
    }

    @Override
    public Object[] getMessageParameters() {
        return new Object[] {};
    }

}