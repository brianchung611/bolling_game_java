package org.example;

public class Round {
    private Integer firstRoll;
    private Integer secondRoll;

    private boolean isEnded;

    public Round() {
        this.isEnded = false;
    }

    public void setFirstRoll(int firstRoll) {
        this.firstRoll = firstRoll;
    }

    public Integer getFirstRoll() {
        return this.firstRoll;
    }

    public void setSecondRoll(int secondRoll) {
        this.secondRoll = secondRoll;
    }

    public Integer getSecondRoll() {
        return this.secondRoll;
    }

    public int getRoundScore() {
        if (this.secondRoll == null) {
            return this.firstRoll;
        }

        return this.firstRoll + this.secondRoll;
    }

    public boolean isStarted() {
        return this.firstRoll != null;
    }

    public void setIsEnded() {
        this.isEnded = true;
    }
    public boolean isEnded() {
        return this.isEnded;
    }
}
