package org.example;

public class Round {
    private int firstRoll;
    private int secondRoll;

//    public Round(int firstRoll) {
//        this.firstRoll = firstRoll;
//        this.secondRoll = 0;
//    }

    public void setFirstRoll(int firstRoll) {
        this.firstRoll = firstRoll;
    }

    public void setSecondRoll(int secondRoll) {
        this.secondRoll = secondRoll;
    }

    public int getRoundScore() {
        if (firstRoll == 10) {
            return firstRoll;
        }

        return firstRoll + secondRoll;
    }
}
