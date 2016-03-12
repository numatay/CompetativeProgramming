package codeforces.cr345;

import java.util.Scanner;

/**
 * Created by ABiryulin on 3/7/2016.
 */
public class ProblemA {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();
        int min = Integer.MAX_VALUE;
        int max = Integer.MAX_VALUE;
        int mins = 0;

        if (a > b) {
            min = a;
            max = b;
        } else {
            min = b;
            max = a;
        }

        if (min == 1 && max == 1) {
            System.out.println('0');
            return;
        }

        while (min > 0 && max > 0) {
            if (min > max) {
                int t = min;
                min = max;
                max = t;
            }
            min += 1;
            max -= 2;
            mins++;
        }

        System.out.println(mins);
    }

}
