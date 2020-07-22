package com.companyname.exercise1;

/**
 * Hello Exercise 1!
 */
public final class App {
    private App() {
    }

    /**
     * Says hello to Exercise 1.
     * @param args The arguments of the program.
     */
    @SuppressWarnings("checkstyle:magicnumber")
    public static void main(String[] args) {
        System.out.println("Hello Exercise 1!");

        // print out "seven thousand four hundred fifty six"
        int input = 7456;
        System.out.println("Input: " + input);
        String result = NumUtils.convertNumberToString(input);
        System.out.println("Output: " + result);
    }
}
