package com.companyname.quicksort;

/**
 * QuickSort algorithm.
 */
public class QuickSort {
    /**
     * quickSort recursive method.
     * @param numbers
     * @param lo
     * @param hi
     * @return
     */
    public int[] quickSort(int[] numbers, int lo, int hi) {
        // debugging
        QuickSort.printContext(numbers, lo, hi);
        // use number at "hi" as pivot, find pivot position, and sort remaining subsets
        if (lo < hi) {
            int partitionBorder = partition(numbers, lo, hi);
            quickSort(numbers, lo, partitionBorder - 1);
            quickSort(numbers, partitionBorder + 1, hi);
        }
        return numbers;
    }

    /**
     * partition - use number at "hi" as pivot, create subsets, and return pivot position.
     * @param numbers
     * @param lo
     * @param hi
     * @return
     */
    private int partition(int[] numbers, int lo, int hi) {
        // use number at "hi" as pivot
        int pivot = numbers[hi];
        int i = lo - 1; // initialize index of smaller element
        // starting at lo, swap elements that are smaller than pivot to left of pivot
        for (int j = lo; j < hi; j++) {
            if (numbers[j] < pivot) {
                i++;
                int temp = numbers[i];
                numbers[i] = numbers[j];
                numbers[j] = temp;
            }
        }
        // swap element occupying pivot position (guarantee > pivot) to "hi"
        numbers[hi] = numbers[i + 1];
        numbers[i + 1] = pivot;
        return i + 1;
    }

    /**
     * printContext - for debugging purpose.
     * @param numbers
     * @param lo
     * @param hi
     */
    private static void printContext(int[] numbers, int lo, int hi) {
        System.out.print("QuickSort.printContext: numbers=[ ");
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i] + " ");
        }
        System.out.println("]，lo=" + lo + ", hi=" + hi);
    }
}
