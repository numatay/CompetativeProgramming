package learn5minutes.sorting;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Arrays;

/**
 * Created by macnur on 2/29/16.
 */
public class SimpleQuickSort {
    public static void main(String[] args) {
        int[] a = {12,32,43,34,23,23,34,45,5,66,76,7,56,45,34,3,4,32,3};

        quickSort(a);

        System.out.println(Arrays.toString(a));

    }

    public static void quickSort(int[] lst) {
        quickSort(lst, 0, lst.length-1);
    }

    private static void quickSort(int[] lst, int l, int r) {
        if (l >= r) return;

        int idx = partitionRhs(lst, l, r);
        quickSort(lst, l, idx-1);
        quickSort(lst, idx+1, r);
    }

    private static int partitionRhs(int[] lst, int l, int r) {
        int pivot = lst[r];

        int tmp;
        int i = l - 1;
        for (int j = l; j < r; j++) {
            if (lst[j] <= pivot) {
                i++;
                // swap
                tmp = lst[j];
                lst[j] = lst[i];
                lst[i] = tmp;
            }
        }
        // swap pivot
        tmp = lst[i+1];
        lst[i+1] = pivot;
        lst[r] = tmp;

        return i+1;
    }

    private static int partitionLhs(int[] lst, int l, int r) {
        int pivot = lst[l];

        int tmp;
        int i = r + 1;
        for (int j = r; j > l; j--) {
            if (lst[j] >= pivot) {
                i--;
                tmp = lst[j];
                lst[j] = lst[i];
                lst[i] = tmp;
            }
        }
        tmp = lst[i-1];
        lst[i-1] = pivot;
        lst[l] = tmp;

        return i-1;
    }

    private static int partitionMid(int[] lst, int l, int r) {
        throw new NotImplementedException();
    }



}
