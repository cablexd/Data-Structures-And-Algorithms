package sort;

import java.util.Arrays;

public class Quicksort<T extends Comparable<T>> {

    public void sort(T[] arr) {
        if (arr.length <= 1)
            return;

        T max = arr[0];
        int maxI = 0;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i].compareTo(max) > 0) {
                max = arr[i];
                maxI = i;
            }
        }

        swap(arr, maxI, arr.length - 1); // put max element at end of array
        sort(arr, 0, arr.length - 1);
    }

    private int partition(T[] arr, int startI, int endI) {
        swap(arr, startI, (startI + endI) / 2); // swap pivot with first element
        T pivot = arr[startI];
        int lowerI = startI + 1;
        int upperI = endI;

        while (lowerI <= upperI) {
            while (arr[lowerI].compareTo(pivot) < 0)
                lowerI++;
            while (arr[upperI].compareTo(pivot) > 0)
                upperI--;

            if (lowerI <= upperI) // <= to prevent infinite loop when pointers both on value equal to pivot
                swap(arr, lowerI++, upperI--);
            System.out.println(Arrays.toString(arr));
        }

        swap(arr, startI, upperI); // move pivot into correct spot
        return upperI;
    }

    private void sort(T[] arr, int startI, int endI) {
        if (endI <= startI || startI < 0 || endI >= arr.length)
            return; // do not sort arrays of length 1
        System.out.println("partitioning from " + startI + " to " + endI);

        // hoare's partitioning
        int partitionI = partition(arr, startI, endI);
        System.out.println("in correct pos: " + arr[partitionI]);
        System.out.println(Arrays.toString(arr));

        sort(arr, startI, partitionI - 1);
        sort(arr, partitionI + 1, endI);
    }

    private void swap(T[] arr, int a, int b) {
        T t = arr[a];
        arr[a] = arr[b];
        arr[b] = t;
    }
}