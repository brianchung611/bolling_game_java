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
        game.addNewRoll(1);
        game.addNewRoll(2);

        assertEquals(3, game.getTotalScore(), "should be equal to 3");
    }

    @Test
    @DisplayName("Ensure adding new round")
    void testAddNewRound() {
        game.addNewRoll(1);
        game.addNewRoll(2);
        game.addNewRoll(3);

        assertEquals(6, game.getTotalScore(), "should be equal to 6");
    }

    @Test
    @DisplayName("Ensure spare round")
    void testSpareRound() {
        game.addNewRoll(5);
        game.addNewRoll(5);
        game.addNewRoll(3);

        assertEquals(16, game.getTotalScore(), "should be equal to 20");
    }

    @Test
    @DisplayName("Ensure two spare rounds")
    void testTwoSpareRounds() {
        game.addNewRoll(5);
        game.addNewRoll(5);
        game.addNewRoll(5);
        game.addNewRoll(5);
        game.addNewRoll(3);

        assertEquals(31, game.getTotalScore(), "should be equal to 31");
    }

    @Test
    @DisplayName("Ensure spare round with unstarted next round")
    void testSpareRoundWithUnstartedNextRound() {
        game.addNewRoll(5);
        game.addNewRoll(5);

        assertEquals(10, game.getTotalScore(), "should be equal to 10");
    }

    @Test
    @DisplayName("Ensure strike round")
    void testStrikeRound() {
        game.addNewRoll(10);
        game.addNewRoll(3);
        game.addNewRoll(2);

        assertEquals(20, game.getTotalScore(), "should be equal to 20");
    }

    @Test
    @DisplayName("Ensure two strike rounds")
    void testTwoStrikeRounds() {
        game.addNewRoll(10);
        game.addNewRoll(10);
        game.addNewRoll(5);
        game.addNewRoll(3);

        assertEquals(51, game.getTotalScore(), "should be equal to 51");
    }
}