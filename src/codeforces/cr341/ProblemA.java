package codeforces.cr341;

import java.util.Scanner;

/**
 * Created by ABiryulin on 2/2/2016.
 */
public class ProblemA {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int minO = Integer.MAX_VALUE;
        int minE = Integer.MAX_VALUE;
        long sum = 0;


        for (int i = 0; i < n; i++) {
            int x = in.nextInt();
            sum += x;
            if (x % 2 == 0 && minE > x) { minE = x; }
            if (x % 2 == 1 && minO > x) { minO = x; }
        }

        if (sum % 2 == 1) {
            sum -= minO;
        }

        System.out.println(sum);
    }
}
