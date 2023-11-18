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
        Round firstRoundWithRoll = new Round();
        firstRoundWithRoll.setFirstRoll(1);

        game.addNewRoll(1);
        assertEquals(firstRoundWithRoll.getRoundScore(), game.getRounds()[0].getRoundScore(), "should be a round with the firstRoll as 1");
    }

    @Test
    @DisplayName("Ensure adding second roll")
    void testAddSecondRoll() {

    }
}