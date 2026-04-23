import java.util.Arrays;

import sort.Mergesort;

public class Main {

    public static void main(String[] args) {
        Integer[] arr = { 15, 82, 4, 67, 15, 99, 23, 48, 71, 36 };
        // 10 5 5 4
        /*
         * 5 10 5 4
         * 5 4 5 10
         */
        System.out.println(Arrays.toString(arr));
        new Mergesort<Integer>().sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}