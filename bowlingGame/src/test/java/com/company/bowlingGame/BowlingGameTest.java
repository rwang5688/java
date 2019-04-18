package com.company.bowlingGame;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class BowlingGameTest {
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
        g.roll(5);
        g.roll(5);
    }

    private void rollStrike() {
        g.roll(10);
    }

    // 1st Test
    @Test
    public void testGutterGame() throws Exception {
        rollMany(20, 0);
        assertEquals(0, g.score());
    }

    // 2nd Test
    @Test
    public void testAllOnes() throws Exception {
        rollMany(20, 1);
        assertEquals(20, g.score());
    }

    // 3rd Test
    @Test
    public void testOneSpare() throws Exception {
        rollSpare();
        g.roll(3); // spare bonus
        rollMany(17, 0);
        assertEquals(16, g.score());
    }

    // 4th Test
    @Test
    public void testOneStrike() throws Exception {
        rollStrike();
        g.roll(3); // strike bonus
        g.roll(4); // strike bonus
        rollMany(16, 0);
        assertEquals(24, g.score());
    }

    // 4th Test
    @Test
    public void testPerfectGame() throws Exception {
        rollMany(12, 10);
        assertEquals(300, g.score());
    }
}
