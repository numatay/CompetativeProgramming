package hackerrank.hourrank7;

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        partition(arr, 0, n, 0);
    }


    private static void partition(int[] a, int l, int r, int round) {
        if (l >= r) { return; }
        System.out.println("\nround " + round + " with l:" + l + " r:" + r) ;
        System.out.println();
        for (int i = l; i < r; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();

        int size = Math.abs(r-l);
        int[] ltor = new int[size];
        int[] rotl = new int[size];

        int sum = 0;
        for (int i = 0, j = l; i < size; i++, j++) {
            sum += a[j];
            ltor[i] = sum;
        }
        sum = 0;
        for (int i = size-1, j = r-1; i >= 0; i--, j--) {
            sum += a[j];
            rotl[i] = sum;
        }

        for (int i = 0; i < size; i++) {
            System.out.print(ltor[i] + " ");
        }
        System.out.println();
        for (int i = 0; i < size; i++) {
            System.out.print(rotl[i] + " ");
        }

        int i = 0, j = size-1;
        int lm = 0, rm = 0;
        while(i < j) {
            if (ltor[i] < rotl[j]) {
                i++;
                lm++;
            }
            else if (ltor[i] >= rotl[j]) {
                j--;
                rm++;
            }
        }
        System.out.print("\n" + lm + " " + rm + "and " + i + " " + j);
        //if (Math.abs())
        if (rm >= lm) {
            partition(a, r-rm, r, round+1);
        } else {
            partition(a, l-lm, lm, round+1);
        }

    }
}