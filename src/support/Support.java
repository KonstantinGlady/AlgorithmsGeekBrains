package support;


import java.util.Random;

public class Support {


    public static int[] getRandomIntArray(int num, int min, int max) {

        Random random = new Random();
        return random.ints(num, min, max).toArray();

    }

    public static int[] getIntArray() {
        return new int[]{-1, 3, 6, -5, 3, 0, -2, 4, -6, -5, 0, -4, -3, -9, 1, -4, 4, 5, -6, 5, -8, 6, -2, -6, -1, 0, 8, -3, 5, -2, -6, 4, 0, 5, 6, -6, -5, -3, 7, 8, 4, 6, -5, 2, -9, -3, -1, -1, 2, -3, -3, 4, 2, 5, -3, 5, -1, -1, 8, 7, 4, 8, 1, -8, -1, -1, 1, -1, -1, -1, 5, -8, -5, 5, -4, -2, -2, -5, 1, 2, -5, -7, 1, 6, -4, 8, -5, 2, -8, 8, -2, 2, 1, -5, 2, -3, 1, -6, -3, 1};
    }

    public static void mergeSort(int[] arr) {
        int[] tmp = new int[arr.length];
        mergeSortInt(arr, tmp, 0, arr.length - 1);
    }

    private static void mergeSortInt(int[] arr, int[] tmp, int lo, int hi) {
        if (hi <= lo) {
            return;
        }
        int mid = lo + (hi - lo) / 2;
        mergeSortInt(arr, tmp, lo, mid);
        mergeSortInt(arr, tmp, mid + 1, hi);
        merge(arr, tmp, lo, mid, hi);
    }

    private static void merge(int[] arr, int[] tmp, int lo, int mid, int hi) {
        for (int k = lo; k <= hi; k++) {
            tmp[k] = arr[k];
        }

        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            if (i > mid) arr[k] = tmp[j++];
            else if (j > hi) arr[k] = tmp[i++];
            else if (tmp[j] < tmp[i]) arr[k] = tmp[j++];
            else arr[k] = tmp[i++];
        }
    }
}
