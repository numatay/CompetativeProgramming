package learn5minutes;

import java.util.Arrays;

/**
 * Created by mcnr on 3/22/16.
 */
public class SimpleMergeSort {
    public static void main(String[] args) {
        int[] randSeq = { 1, 34, 45, 34, 45};

        mergeSort(randSeq);

        System.out.println(Arrays.toString(randSeq));
    }


    public static void mergeSort(int[] arr) {
        if (arr.length < 2) return;

        int[] tmp = new int[arr.length];
        mergeSort(arr, tmp, 0, arr.length-1);
    }

    private static void mergeSort(int[] arr, int[] tmp, int l, int r) {
        // base step
        if (r == l) { return; }

        //recursive step
        int mid = (r + l) / 2;

        // divide
        mergeSort(arr, tmp, l, mid);
        mergeSort(arr, tmp, mid+1, r);

        // conquer
        merge(arr, tmp, l, mid, r);
    }

    private static void merge(int[] a, int[] t, int l, int mid, int r) {
        int i = l, j = mid+1, pos = l;
        // two index finger technique
        for (; i <= mid && j <= r;) {
            if (a[i] < a[j]) {
                t[pos++] = a[i++];
            } else {
                t[pos++] = a[j++];
            }
        }

        // copy rest of the elements
        if (i <= mid) {
            for (; i <= mid;)
                t[pos++] = a[i++];
        } else if (j <= r) {
            for (; j <= r; )
                t[pos++] = a[j++];
        } else {
            throw new RuntimeException("This should not happen");
        }

        // copy to original from sorted temp array
        for (; l <= r; l++)
            a[l] = t[l];
    }
}
