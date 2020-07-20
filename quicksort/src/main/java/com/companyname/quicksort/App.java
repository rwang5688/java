package com.companyname.quicksort;

/**
 * Hello world!
 */
public final class App {
    private App() {
    }

    /**
     * Run Quick Sort app.
     * @param args The arguments of the program.
     */
    public static void main(String[] args) {
        System.out.println("App: Quick Sort");
        final int[] numbers = {13, 12, 14, 6, 7};
        QuickSort qs = new QuickSort();
        qs.quickSort(numbers, 0, numbers.length - 1);
    }
}
