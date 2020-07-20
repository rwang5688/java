package com.companyname.quicksort;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * Unit test for simple App.
 */
class QuickSortTest {
    /**
     * Sort array with 5 items.
     */
    @Test
    public void test_quickSort5Items() {
        final int[] numbers = {13, 12, 14, 6, 7};
        final int[] expected = {6, 7, 12, 13, 14};
        QuickSort qs = new QuickSort();
        qs.quickSort(numbers, 0, numbers.length - 1);
        assertArrayEquals(expected, numbers);
    }

    /**
     * Sort array with 10 items.
     */
    @Test
    public void test_quickSort10Items() {
        final int[] numbers = {7, 9, 1, 4, 9, 12, 4, 13, -2, 9};
        final int[] expected = {-2, 1, 4, 4, 7, 9, 9, 9, 12, 13};
        QuickSort qs = new QuickSort();
        qs.quickSort(numbers, 0, numbers.length - 1);
        assertArrayEquals(expected, numbers);
    }
}
