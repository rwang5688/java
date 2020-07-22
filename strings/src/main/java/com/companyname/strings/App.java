package com.companyname.strings;

/**
 * Hello Strings!
 */
public final class App {
    private App() {
    }

    /**
     * printCharArray - print character array contents.
     * @param s
     */
    private static void printCharArray(char[] s) {
        System.out.print("printCharArray: [ ");
        for (int i = 0; i < s.length; i++) {
            System.out.print(s[i] + " ");
        }
        System.out.println("]");
    }

    /**
     * Says hello to Strings.
     * @param args The arguments of the program.
     */
    @SuppressWarnings("checkstyle:magicnumber")
    public static void main(String[] args) {
        System.out.println("Hello Strings!");

        // reverseString
        System.out.println("reverseString:");
        String string1 = "reverse";
        char[] s1 = string1.toCharArray();
        System.out.println("Input: " + string1);
        printCharArray(s1);
        StringUtils.reverseString(s1);
        string1 = String.copyValueOf(s1);
        printCharArray(s1);
        System.out.println("Output: " + string1);

        // reverseDigits
        System.out.println("reverseDigits:");
        int num2 = -123;
        System.out.println("Input: " + Integer.toString(num2));
        num2 = StringUtils.reverseDigits(num2);
        System.out.println("Output: " + Integer.toString(num2));

        // findFirstUnique
        System.out.println("firstUniqChar:");
        String string3 = "loveleetcode";
        System.out.println("Input: " + string3);
        int firstUnique = StringUtils.firstUniqChar(string3);
        System.out.println("First unique character is at: " + Integer.toString(firstUnique));
    }
}
