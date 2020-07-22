package com.companyname.array;

/**
 * Hello Array!
 */
public final class App {
    private App() {
    }

    /**
     * printArray - print array contents from 0 to length-1.
     * @param nums
     * @param length
     */
    private static void printArray(int[] nums, int length) {
        // if asking to print beyond array length, do nothing
        if (length > nums.length) {
            return;
        }
        // print array contents 0 to length-1
        System.out.print("printArray: [ ");
        for (int i = 0; i < length - 1; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println("]");
    }

    /**
     * Says hello to Array.
     * @param args The arguments of the program.
     */
    @SuppressWarnings("checkstyle:magicnumber")
    public static void main(String[] args) {
        System.out.println("Hello Array!");

        // remove duplicates
        System.out.println("removeDuplicates:");
        int[] nums1 = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        printArray(nums1, nums1.length);
        int noDupLength = ArrayUtils.removeDuplicates(nums1);
        printArray(nums1, noDupLength);

        // rotate right k times
        System.out.println("rotate:");
        int[] nums2 = {1, 2, 3, 4, 5, 6, 7};
        printArray(nums2, nums2.length);
        ArrayUtils.rotate(nums2, 3);
        printArray(nums2, nums2.length);

        // contains duplicate
        System.out.println("containsDuplicate:");
        int[] nums3 = {1, 1, 1, 3, 3, 4, 3, 2, 4, 2};
        printArray(nums3, nums3.length);
        boolean containsDuplicate = ArrayUtils.containsDuplicate(nums3);
        System.out.println("containsDuplicate returns: " + containsDuplicate);
    }
}
