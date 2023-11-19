package org.example;

public class Game {
    private final Round[] rounds;

    private final Integer[] extraRolls;

    public Game() {
        this.rounds = new Round[10];
        this.extraRolls = new Integer[2];
    }

    public void addNewRoll(int score) {
        int latestRound = 0;
        for (Round round : rounds) {
            if (round == null || !round.isEnded()) {
                break;
            }
            latestRound++;
        }

        if (latestRound >= 10) {
            if (this.extraRolls[0] == null) {
                this.extraRolls[0] = score;
            } else {
                this.extraRolls[1] = score;
            }
        } else if (this.rounds[latestRound] == null || !this.rounds[latestRound].isStarted()) {
            Round newRound = new Round();
            newRound.setFirstRoll(score);
            if (isStrike(score)) {
                newRound.setIsEnded();
            }
            this.rounds[latestRound] = newRound;
        } else {
            Round updatedRound = this.rounds[latestRound];
            updatedRound.setSecondRoll(score);
            updatedRound.setIsEnded();
            this.rounds[latestRound] = updatedRound;
        }
    }

    public boolean isStrike(int score) {
        return score == 10;
    }

    public Round[] getRounds() {
        return rounds;
    }

    public int getTotalScore() {
        int score = 0;
        for(int i = 0; i < rounds.length; i++) {
            if (rounds[i] == null) {
                break;
            }

            score += rounds[i].getRoundScore();

            if (i < 9) {
                if (rounds[i].getRoundScore() == 10 && rounds[i + 1] != null) {
                    score += rounds[i + 1].getFirstRoll();
                }
            }

            if (i < 8) {
                if (rounds[i].getFirstRoll() == 10 && rounds[i+1].getSecondRoll() != null) {
                    score += rounds[i+1].getSecondRoll();
                } else if (rounds[i].getFirstRoll() == 10 && rounds[i+2] != null) {
                    score += rounds[i+2].getFirstRoll();
                }
            }
        }

        if (this.rounds[9] != null && this.rounds[8].getFirstRoll() == 10 && this.rounds[9].getFirstRoll() == 10 && this.extraRolls[0] != null) {
            score += this.extraRolls[0];
        }

        if (this.extraRolls[0] != null) {
            score += this.extraRolls[0];
        }

        if (this.extraRolls[1] != null) {
            score += this.extraRolls[1];
        }

        return score;
    }
}
