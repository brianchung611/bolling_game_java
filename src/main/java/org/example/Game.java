package org.example;

public class Game {
    private final Round[] rounds;

    public Game() {
        this.rounds = new Round[10];
    }

    public void addNewRoll(int score) {
        Round newRound = new Round();
        newRound.setFirstRoll(score);
        this.rounds[0] = newRound;
    }

    public Round[] getRounds() {
        return rounds;
    }
}
