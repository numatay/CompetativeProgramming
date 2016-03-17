package sorting;

/**
 * Created by macnur on 2/29/16.
 */
public class QuickSortDemo {
    public static void main(String[] args) {
        int[] a = {8, 9, 3, 7, 12, 13, 50};

        quickSort(a, 0, a.length-1);

        for (int x: a) {
            System.out.print(x + " ");
        }
    }

    private static void quickSort(int[] a, int l, int r) {
        if (r-l == 1) return;

        int pivot = a[l];
        System.out.println(pivot);
        while (l <= r) {
            System.out.println("l " + l);
            System.out.println("r " + r);
            for(; a[l] < pivot; l++) {}
            for(; a[r] > pivot; r--) {}


            //swap
            if (l <= r) {
                int tmp = a[l];
                a[l] = a[r];
                a[r] = tmp;
                System.out.println("swapped " + a[r] + " with " + a[l]);
                l++;
                r--;
            }

        }
        for (int x: a) {
            System.out.print(x + " ");
        }
        System.out.println();
        System.out.println("l " + l);
        System.out.println("r " + r);
    }


}
