package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RoundTest {

    Round round;

    @BeforeEach
    void setUp() {
        round = new Round();
    }

    @Test
    @DisplayName("Ensure firstRoll value")
    void testFirstRoll() {
        round.setFirstRoll(1);
        assertEquals(1, round.getRoundScore(), "hihi");
    }

    @Test
    @DisplayName("Ensure secondRoll value")
    void testSecondRoll() {
        round.setFirstRoll(1);
        round.setSecondRoll(2);
        assertEquals(3, round.getRoundScore(), "hihihi");
    }
}