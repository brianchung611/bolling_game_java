package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    Game game;

    @BeforeEach
    void setUp() { game = new Game(); }

    @Test
    @DisplayName("Ensure game has 10 rounds")
    void testTenRounds() {
        assertEquals(10, game.getRounds().length, "should be equal to 10");
    }

    @Test
    @DisplayName("Ensure adding first roll")
    void testAddFirstRoll() {
        game.addNewRoll(1);
        assertEquals(1, game.getTotalScore(), "should be equal to 1");
    }

    @Test
    @DisplayName("Ensure adding second roll")
    void testAddSecondRoll() {
        addNormalRound(game, 1);

        assertEquals(6, game.getTotalScore(), "should be equal to 3");
    }

    @Test
    @DisplayName("Ensure adding new round")
    void testAddNewRound() {
        addNormalRound(game, 1);
        game.addNewRoll(3);

        assertEquals(9, game.getTotalScore(), "should be equal to 6");
    }

    @Test
    @DisplayName("Ensure spare round")
    void testSpareRound() {
        addSpareGame(game, 1);
        game.addNewRoll(3);

        assertEquals(16, game.getTotalScore(), "should be equal to 20");
    }

    @Test
    @DisplayName("Ensure two spare rounds")
    void testTwoSpareRounds() {
        addSpareGame(game, 2);
        game.addNewRoll(3);

        assertEquals(31, game.getTotalScore(), "should be equal to 31");
    }

    @Test
    @DisplayName("Ensure spare round with not started next round")
    void testSpareRoundWithNotStartedNextRound() {
        addSpareGame(game, 1);

        assertEquals(10, game.getTotalScore(), "should be equal to 10");
    }

    @Test
    @DisplayName("Ensure strike round")
    void testStrikeRound() {
        addStrikeGame(game, 1);
        addNormalRound(game, 1);

        assertEquals(22, game.getTotalScore(), "should be equal to 20");
    }

    @Test
    @DisplayName("Ensure two strike rounds")
    void testTwoStrikeRounds() {
        addStrikeGame(game, 2);
        addNormalRound(game, 1);

        assertEquals(45, game.getTotalScore(), "should be equal to 51");
    }

    @Test
    @DisplayName("Ensure 10th round with spare has extra roll")
    void testTenthRoundWithSpareHasExtraRoll() {
        addZeroRound(game, 9);
        addSpareGame(game, 1);
        game.addNewRoll(5);

        assertEquals(15, game.getTotalScore(), "should be equal to 20");
    }

    @Test
    @DisplayName("Ensure 10th round with strike has two extra rolls")
    void testTenthRoundWithStrikeHasTwoExtraRolls() {
        addZeroRound(game, 9);
        addStrikeGame(game, 1);
        game.addNewRoll(5);
        game.addNewRoll(3);

        assertEquals(18, game.getTotalScore(), "should be equal to 18");
    }

    private void addStrikeGame(Game game, int numberOfRound) {
        int i =0;
        while(i < numberOfRound) {
            game.addNewRoll(10);
            i++;
        }
    }

    private void addSpareGame(Game game, int numberOfRound) {
        addRound(game, 5, numberOfRound);
    }

    private void addNormalRound(Game game, int numberOfRound) {
        addRound(game, 3, numberOfRound);
    }

    private void addZeroRound(Game game, int numberOfRound) {
        addRound(game, 0, numberOfRound);
    }

    private void addRound(Game game, int rollScore, int numberOfRound) {
        int i = 0;
        while(i < numberOfRound) {
            game.addNewRoll(rollScore);
            game.addNewRoll(rollScore);
            i++;
        }
    }
}