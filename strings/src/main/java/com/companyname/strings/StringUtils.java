package com.companyname.strings;

import java.util.HashMap;
import java.util.Map;

/**
 * String utilities.
 */
public final class StringUtils {

    private StringUtils() {}

    /**
     * reverseString - reverse a string (that is stored as a char array).
     * @param s
     */
    public static void reverseString(char[] s) {
        // check length
        int length = s.length;
        if (length == 0) {
            return;
        }
        // iterate length/2 times, swapping (i, length-1-i)
        for (int i = 0; i < length / 2; i++) {
            // swap
            char temp = s[i];
            s[i] = s[length - 1 - i];
            s[length - 1 - i] = temp;
        }
    }

    /**
     * reverseDigits - reverse the digits of integer "x".
     * @param x
     * @return 0 if overflow; otherwise: integer with the digits of "x" reversed
     */
    @SuppressWarnings("checkstyle:magicnumber")
    public static int reverseDigits(int x) {
        int input = x;
        int rev = 0;
        // starting with the rightmost digit, cycle through each digit
        while (input != 0) {
            // get rightmost digit
            int rightmostDigit = input % 10;
            // pop rightmost digit
            input = input / 10;
            // check for overflow
            if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && rightmostDigit > 7)) {
                return 0;
            }
            if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && rightmostDigit < -8)) {
                return 0;
            }
            // rotate rightmost digit to left
            rev = rev * 10 + rightmostDigit;
        }
        return rev;
    }

    /**
     * firstUniqChar - find the first character in the string that only appears once.
     * @param s
     * @return position of first character that appears only once; -1 if no char is unique
     */
    public static int firstUniqChar(String s) {
        // build hashmap to look up number of occurrences of each character
        char[] charArray = s.toCharArray();
        Map<Character, Integer> hm = new HashMap<Character, Integer>();
        for (int i = 0; i < charArray.length; i++) {
            char c = charArray[i];
            boolean charExists = hm.containsKey(c);
            if (!charExists) {
                // first instance
                hm.put(c, 1);
            } else {
                // increment count
                int count = hm.get(c);
                hm.put(c, count + 1);
            }
        }

        // find the first character that appears only once
        for (int i = 0; i < charArray.length; i++) {
            char c = charArray[i];
            int count = hm.get(c);
            if (count == 1) {
                return i;
            }
        }

        // no unique character
        return -1;
    }
}
