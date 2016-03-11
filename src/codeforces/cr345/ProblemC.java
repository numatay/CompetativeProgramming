package codeforces.cr345;

import java.util.Scanner;

/**
 * Created by ABiryulin on 3/7/2016.
 */
public class ProblemC {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] xs = new int[n];
        int[] ys = new int[n];

        for (int i = 0; i < n; i++) {
            xs[i] = in.nextInt();
            ys[i] = in.nextInt();
        }


        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                if (xs[i] - xs[j] == 0) {
                    cnt ++;
                    continue;
                }
                if (ys[i] - ys[j] == 0) {
                    cnt++;
                    continue;
                }
                //System.out.println("Considering xs " + xs[i] + " " +  xs[j]);
                //System.out.println("Considering ys " + ys[i] + " " +  ys[j]);

            }
        }
        System.out.println(cnt);
    }
}
