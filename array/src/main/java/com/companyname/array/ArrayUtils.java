package com.companyname.array;

import java.util.Arrays;

/**
 * Array utilities.
 */
public final class ArrayUtils {

    private ArrayUtils() {}

    /**
     * removeDuplicates - assume sorted array of numbers, remove duplicates.
     * @param nums
     * @return new length with only unique entries
     */
    public static int removeDuplicates(int[] nums) {
        // check for empty array
        if (nums.length == 0) {
            return 0;
        }
        // if array is not empty, count is at least 1, with first entry being num[0]
        int count = 1;
        int lastEntry = nums[0];
        // starting at position 1, cycle through the input array
        for (int i = 1; i < nums.length; i++) {
            int currentEntry = nums[i];
            // if current entry different from last entry, update last entry and overwrite array
            if (currentEntry != lastEntry) {
                lastEntry = currentEntry;
                nums[count] = currentEntry;
                count++;
            }
        }
        return count;
    }

    /**
     * rotate - rotate right k times.
     * @param nums
     * @param k
     */
    public static void rotate(int[] nums, int k) {
        // array too short; nothing to do
        if (nums.length < 2) {
            return;
        }
        for (int i = 0; i < k; i++) {
            rotateRight(nums);
        }
    }

    /**
     * rotateRight - rotate array right one time.
     * @param nums
     */
    private static void rotateRight(int[] nums) {
        int length = nums.length;
        int origTail = nums[length - 1];
        // shift contents to right by 1
        for (int i = length - 2; i >= 0; i--) {
            nums[i + 1] = nums[i];
        }
        // put original tail as head
        nums[0] = origTail;
    }

    /**
     * containsDuplicate - check if array has duplicate contents.
     * @param nums
     * @return true if duplicate exists; false if not
     */
    public static boolean containsDuplicate(int[] nums) {
        int length = nums.length;
        // fewer than 2 elements, no duplicates
        if (length < 2) {
            return false;
        }

        // sort array
        Arrays.sort(nums);
        // if two consecutive entries are the same, found first duplicate
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                return true;
            }
        }

        // no two consecutive entries are the same -> no duplicate
        return false;
    }
}
