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
        assertEquals(1, round.getRoundScore(), "should be equal to 1");
    }

    @Test
    @DisplayName("Ensure secondRoll value")
    void testSecondRoll() {
        round.setFirstRoll(1);
        round.setSecondRoll(2);
        assertEquals(3, round.getRoundScore(), "should be equal to 3");
    }

    @Test
    @DisplayName("Ensure isStarted() return true when there is value in first roll")
    void testIsStartedTrue() {
        round.setFirstRoll(1);
        assertTrue(round.isStarted(), "should be true");
    }

    @Test
    @DisplayName("Ensure isStarted() return false when there is no value in first roll")
    void testIsStartedFalse() {
        assertFalse(round.isStarted(), "should be false");
    }

    @Test
    @DisplayName("Ensure isEnded() return true when there is value in second roll")
    void testIsEndedTrue() {
        round.setFirstRoll(1);
        round.setFirstRoll(2);
        assertTrue(round.isStarted(), "should be true");
    }

    @Test
    @DisplayName("Ensure isEnded() return false when there is no value in second roll")
    void testIsEndedFalse() {
        assertFalse(round.isStarted(), "should be false");
    }
}