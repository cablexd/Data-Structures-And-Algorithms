package sort;

import java.util.ArrayDeque;
import java.util.Queue;

public class RadixSort {

    private static final int RADIX = 10; // number of "buckets"

    private int getMaxDigits(int[] arr) {
        int max = -1;

        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
        }

        return (max == 0) ? 1 : ((int) Math.log10(max)) + 1;
    }

    @SuppressWarnings("unchecked")
    public void sort(int[] arr) {
        if (arr.length <= 1)
            return;

        int d = getMaxDigits(arr);
        Queue<Integer>[] queues = new Queue[RADIX];

        for (int i = 0; i < RADIX; i++) {
            queues[i] = new ArrayDeque<>();
        }

        int factor = 1; // used for getting index of value at specific iteration of n

        for (int n = d - 1; n >= 0; n--, factor *= RADIX) {
            for (int i = 0; i < arr.length; i++) {
                int v = arr[i];
                int slot = (v / factor) % RADIX;
                queues[slot].add(v);
            }

            // add values back from queues to main array
            int k = 0;

            for (int i = 0; i < RADIX; i++) {
                Queue<Integer> queue = queues[i];

                while (!queue.isEmpty()) {
                    arr[k++] = queue.poll();
                }
            }
        }
    }
}