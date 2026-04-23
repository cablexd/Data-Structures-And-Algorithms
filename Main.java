import java.util.Arrays;

import sort.CountingSort;

public class Main {

    public static void main(String[] args) {
        int[] arr = { 14, 27, 4, 82, 19, 63, 50, 8, 35, 71 };
        System.out.println(Arrays.toString(arr));
        new CountingSort().sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}