package com.company.bowlinggame;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Bowling Game Unit Tests.
 */
class BowlingGameTest {

    private static final int NUM_FRAMES = 10;
    private static final int NUM_ROLLS_IN_OPEN_GAME = 2 * NUM_FRAMES;
    private static final int NUM_PINS_IN_STRIKE = 10;
    private static final int FIRST_ROLL = 5;
    private static final int SECOND_ROLL = 5;
    private static final int SPARE_BONUS = 3;
    private static final int NUM_ROLLS_IN_TEST_ONE_SPARE = 3;
    private static final int STRIKE_BONUS_1 = 3;
    private static final int STRIKE_BONUS_2 = 4;
    private static final int NUM_ROLLS_IN_TEST_ONE_STRIKE = 4;
    private static final int NUM_ROLLS_IN_PERFECT_GAME = 12;
    private static final int PERFECT_GAME_SCORE = 300;

    private Game g;

    // remove Game creation duplicate
    @BeforeEach
    protected void setUp() throws Exception {
        g = new Game();
    }

    // helper functions
    private void rollMany(int n, int pins) {
        for (int i = 0; i < n; i++) {
            g.roll(pins);
        }
    }

    private void rollSpare() {
        g.roll(FIRST_ROLL);
        g.roll(SECOND_ROLL);
    }

    private void rollStrike() {
        g.roll(NUM_PINS_IN_STRIKE);
    }

    // 1st Test
    @Test
    public void testGutterGame() throws Exception {
        rollMany(NUM_ROLLS_IN_OPEN_GAME, 0);
        assertEquals(0, g.score());
    }

    // 2nd Test
    @Test
    public void testAllOnes() throws Exception {
        rollMany(NUM_ROLLS_IN_OPEN_GAME, 1);
        assertEquals(NUM_ROLLS_IN_OPEN_GAME, g.score());
    }

    // 3rd Test
    @Test
    public void testOneSpare() throws Exception {
        rollSpare(); // pick up spare in 1st frame
        g.roll(SPARE_BONUS); // spare bonus = 3
        rollMany(NUM_ROLLS_IN_OPEN_GAME - NUM_ROLLS_IN_TEST_ONE_SPARE, 0); // gutter ball for remaining rolls
        assertEquals(NUM_PINS_IN_STRIKE + SPARE_BONUS + SPARE_BONUS, g.score());
    }

    // 4th Test
    @Test
    public void testOneStrike() throws Exception {
        rollStrike();
        g.roll(STRIKE_BONUS_1); // strike bonus 1 = 3
        g.roll(STRIKE_BONUS_2); // strike bonus 2 = 4
        rollMany(NUM_ROLLS_IN_OPEN_GAME - NUM_ROLLS_IN_TEST_ONE_STRIKE, 0); // gutter ball for remaining rolls
        assertEquals(NUM_PINS_IN_STRIKE + 2 * (STRIKE_BONUS_1 + STRIKE_BONUS_2), g.score());
    }

    // 4th Test
    @Test
    public void testPerfectGame() throws Exception {
        rollMany(NUM_ROLLS_IN_PERFECT_GAME, NUM_PINS_IN_STRIKE);
        assertEquals(PERFECT_GAME_SCORE, g.score());
    }
}
