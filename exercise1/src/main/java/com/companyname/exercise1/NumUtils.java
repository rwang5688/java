package com.companyname.exercise1;

/**
 * NumUtilities.
 */
public final class NumUtils {

    private NumUtils() {}

    /**
     * convertDigitToString.
     * @param digit
     * @return
     */
    @SuppressWarnings("checkstyle:magicnumber")
    private static String convertDigitToString(int digit) {
        String result;
        switch (digit) {
            case 0:
                result = "zero";
                break;
            case 1:
                result = "one";
                break;
            case 2:
                result = "two";
                break;
            case 3:
                result = "three";
                break;
            case 4:
                result = "four";
                break;
            case 5:
                result = "five";
                break;
            case 6:
                result = "six";
                break;
            case 7:
                result = "seven";
                break;
            case 8:
                result = "eight";
                break;
            case 9:
                result = "nine";
                break;
            default:
                result = "error";
        }
        return result;
    }

    /**
     * convertTensToString.
     * @param tensDigit
     * @return string that matches the tensDigit
     */
    @SuppressWarnings("checkstyle:magicnumber")
    private static String convertTensToString(int tensDigit) {
        String result;
        switch (tensDigit) {
            case 0:
                result = "and";
                break;
            case 1:
                result = "ten";
                break;
            case 2:
                result = "twenty";
                break;
            case 3:
                result = "thirty";
                break;
            case 4:
                result = "forty";
                break;
            case 5:
                result = "fifty";
                break;
            case 6:
                result = "sixty";
                break;
            case 7:
                result = "seventy";
                break;
            case 8:
                result = "eighty";
                break;
            case 9:
                result = "ninty";
                break;
            default:
                result = "error";
        }
        return result;
    }

    /**
     * convertNumberToString.
     * @param number
     * @return string that reads out the number by digit
     */
    @SuppressWarnings("checkstyle:magicnumber")
    public static String convertNumberToString(int number) {
        int remainder = number;
        String result = "";
        int position = 1;
        while (remainder != 0) {
            int rightmostDigit = remainder % 10;
            remainder = remainder / 10;
            if ((position == 1) && (rightmostDigit > 0)) {
                result = convertDigitToString(rightmostDigit);
            } else if (position == 10) {
                result = convertTensToString(rightmostDigit) + " " + result;
            } else if (position == 100) {
                result = convertDigitToString(rightmostDigit) + " hundred " + result;
            } else if (position == 1000) {
                result = convertDigitToString(rightmostDigit) + " thousand " + result;
            }
            position = position * 10;
        }
        return result;
    }
}
