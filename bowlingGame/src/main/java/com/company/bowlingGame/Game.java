package com.company.bowlinggame;

/**
 * Bowling game.
 */
public class Game {

    private static final int NUM_FRAMES = 10;
    private static final int MAX_NUM_ROLLS = 21;
    private static final int NUM_PINS_IN_STRIKE = 10;

    private int[] rolls;
    private int currentRoll;

    /**
     * Initialize Game.
     */
    public Game() {
        rolls = new int[MAX_NUM_ROLLS];
        for (int i = 0; i < MAX_NUM_ROLLS; i++) {
            rolls[i] = 0;
        }
        currentRoll = 0;
    }

    /**
     * Store num pins in each roll.
     */
    public void roll(final int pins) {
        rolls[currentRoll++] += pins;
    }

    /**
     * Calculate score.
     */
    public int score() {
        int score = 0;
        int rollIndex = 0;
        for (int frameIndex = 0; frameIndex < NUM_FRAMES; frameIndex++) {
            if (isStrike(rollIndex)) {
                score += NUM_PINS_IN_STRIKE + strikeBonus(rollIndex);
                rollIndex += 1;
            } else if (isSpare(rollIndex)) {
                score += NUM_PINS_IN_STRIKE + spareBonus(rollIndex);
                rollIndex += 2;
            } else {
                score += sumOfBallsInFrame(rollIndex);
                rollIndex += 2;
            }
        }
        return score;
    }

    /**
     * Check is strike.
     */
    private boolean isStrike(final int rollIndex) {
        return rolls[rollIndex] == NUM_PINS_IN_STRIKE;
    }

    /**
     * Strike rule.
     */
    private int strikeBonus(final int rollIndex) {
        return rolls[rollIndex + 1] + rolls[rollIndex + 2];
    }

    /**
     * Check is spare.
     * @param rollIndex
     * @return
     */
    private boolean isSpare(final int rollIndex) {
        return rolls[rollIndex] + rolls[rollIndex + 1] == NUM_PINS_IN_STRIKE;
    }

    /**
     * Spare rule.
     * @param rollIndex
     * @return
     */
    private int spareBonus(final int rollIndex) {
        return rolls[rollIndex + 2];
    }

    /**
     * Sum balls in frame.
     */
    private int sumOfBallsInFrame(final int rollIndex) {
        return rolls[rollIndex] + rolls[rollIndex + 1];
    }
}
