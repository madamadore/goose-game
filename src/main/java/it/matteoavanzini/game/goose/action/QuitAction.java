package it.matteoavanzini.game.goose.action;

import java.util.Scanner;

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
        Scanner scanner = new Scanner(System.in);
        System.out.print("Game is not ended. Are you sure? ");
        String response = scanner.nextLine();
        scanner.close();
        if (response.equalsIgnoreCase("Y") || response.equalsIgnoreCase("yes")) {
            game.endGame();
        }
        return true;
    }

    @Override
    public Object[] getMessageParameters() {
        return new Object[] {};
    }

}