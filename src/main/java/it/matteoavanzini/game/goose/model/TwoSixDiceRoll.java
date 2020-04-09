package it.matteoavanzini.game.goose.model;

public class TwoSixDiceRoll implements DiceRoll {

    int[] dice = new int[2];
    public void roll() {
        dice[0] = 1 + (int) (Math.random() * 6);
        dice[1] = 1 + (int) (Math.random() * 6);
    }

    public int getSum() {
        return dice[0] + dice[1];
    }

    public int[] getResult() {
        return dice;
    }

    public void setRoll(int... roll) {
        dice[0] = roll[0];
        dice[1] = roll[1];
    }

}