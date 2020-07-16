package com.company.bowlinggame;

/**
 * Bowling Game sample app.
 */
public final class App {

    private static final int NUM_ROLLS_IN_PERFECT_GAME = 12;
    private static final int NUM_PINS_IN_STRIKE = 10;

    private App() {
    }

    /**
     * Says hello to the world.
     * @param args The arguments of the program.
     */
    public static void main(String[] args) {
        System.out.println("Bowling Game!");
        Game g = new Game();
        for (int i = 0; i < NUM_ROLLS_IN_PERFECT_GAME; i++) {
            g.roll(NUM_PINS_IN_STRIKE);
        }
        System.out.println("Perfect Game score is: " + g.score());
    }
}
