package it.matteoavanzini.game.goose.model;

public interface DiceRoll {
    void roll();
    int getSum();
    int[] getResult();
    void setRoll(int... roll);
}