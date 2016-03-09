package codeforces.cr344;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by ABiryulin on 3/9/2016.
 */
public class ProblemA {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Set<Integer> s = new HashSet<>();
        int n = in.nextInt();
        int m1 = Integer.MIN_VALUE;
        int v1 = 0;
        int v2 = 0;
        int m2 = Integer.MIN_VALUE;
        int[] a = new int[n];
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
            //m1 = Math.max(m1, a[i]);
            v1 |= a[i];
        }
        for (int i = 0; i < n; i++) {
            b[i] = in.nextInt();
            //m2 = Math.max(m1, b[i]);
            v2 |= b[i];
        }

        System.out.println(v1+v2);

    }
}
