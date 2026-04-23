package sort;

public class CountingSort {

    private int getMaxValue(int[] arr) {
        int max = arr[0];

        for (int i = 1; i < arr.length; i++) {
            max = Math.max(arr[i], max);
        }

        return max;
    }

    public void sort(int[] arr) {
        int max = getMaxValue(arr);
        int[] counts = new int[max + 1];

        for (int v : arr) {
            counts[v]++;
        }

        // aggregate counts
        for (int i = 1; i < counts.length; i++) {
            counts[i] = counts[i - 1] + counts[i];
        }

        // move values to temp array using counts
        int[] temp = new int[arr.length];

        for (int i = arr.length - 1; i >= 0; i--) {
            int v = arr[i];
            int numberLeq = counts[v];
            int index = numberLeq - 1;
            temp[index] = v;
            counts[v]--;
        }

        // copy temp back to main array
        for (int i = 0; i < arr.length; i++) {
            arr[i] = temp[i];
        }
    }
}
