import java.util.Arrays;

import sort.RadixSort;

public class Main {

    public static void main(String[] args) {
        int[] arr = { 0, 0 };
        System.out.println(Arrays.toString(arr));
        new RadixSort().sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}