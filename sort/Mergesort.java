package sort;

import java.util.Arrays;

public class Mergesort<T extends Comparable<T>> {

    private Object[] arr0;

    public void sort(T[] arr) {
        arr0 = new Object[arr.length];
        sort(arr, 0, arr.length - 1);
        arr0 = null;
    }

    @SuppressWarnings("unchecked")
    private void sort(T[] arr, int startI, int endI) {
        if (startI >= endI)
            return; // already sorted

        System.out.println("Sorting from " + startI + " to " + endI + ": " + Arrays.toString(arr));

        int midI = (startI + endI) / 2;
        sort(arr, startI, midI);
        sort(arr, midI + 1, endI);

        int leftI = startI;
        int rightI = midI + 1;
        int nextI = startI;

        // add elements from both sides to temp array in order
        while (leftI <= midI && rightI <= endI) { // both sides have elements -> compare
            T nextLeft = arr[leftI];
            T nextRight = arr[rightI];

            if (nextLeft.compareTo(nextRight) <= 0) {
                arr0[nextI++] = arr[leftI++];
            } else {
                arr0[nextI++] = arr[rightI++];
            }
        }
        while (leftI <= midI) { // left side only has elements
            arr0[nextI++] = arr[leftI++];
        }
        while (rightI <= endI) { // right side only has elements
            arr0[nextI++] = arr[rightI++];
        }

        // add elements from temp array back to main array
        for (int i = startI; i <= endI; i++) {
            arr[i] = (T) arr0[i];
        }

        System.out.println("Sorted from " + startI + " to " + endI + ": " + Arrays.toString(arr));
    }
}