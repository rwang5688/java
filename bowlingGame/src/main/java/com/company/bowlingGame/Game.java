package com.company.bowlingGame;

public class Game {
    private int rolls_[];
    private int currentRoll_;

    // initialize class variables
    public Game() {
        rolls_ = new int[21];
        for (int i = 0; i < 21; i++)
            rolls_[i] = 0;
        currentRoll_ = 0;
    }

    // accumulate  score
    public void roll(int pins) {
        rolls_[currentRoll_++] += pins;
    }

    // return score
    public int score() {
        int score = 0;
        int rollIndex = 0;
        for (int frameIndex = 0; frameIndex < 10; frameIndex++) {
            if (isStrike(rollIndex)) {
                score += 10 + strikeBonus(rollIndex);
                rollIndex += 1;
            } else if (isSpare(rollIndex)) {
                score += 10 + spareBonus(rollIndex);
                rollIndex += 2;
            } else {
                score += sumOfBallsInFrame(rollIndex);
                rollIndex += 2;
            }
        }
        return score;
    }

    // game rules
    private boolean isStrike(int rollIndex) {
        return rolls_[rollIndex] == 10;
    }

    private int strikeBonus(int rollIndex) {
        return rolls_[rollIndex+1] + rolls_[rollIndex+2];
    }

    private boolean isSpare(int rollIndex) {
        return rolls_[rollIndex] + rolls_[rollIndex+1] == 10;
    }

    private int spareBonus(int rollIndex) {
        return rolls_[rollIndex+2];
    }

    private int sumOfBallsInFrame(int rollIndex) {
        return rolls_[rollIndex] + rolls_[rollIndex+1];
    }
}