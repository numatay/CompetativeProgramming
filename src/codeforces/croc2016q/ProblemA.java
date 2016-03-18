package codeforces.croc2016q;

import java.util.Scanner;

/**
 * Created by Nurgissa on 3/17/2016.
 */

public class ProblemA {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int a = in.nextInt();
        int b = in.nextInt();

        if (n > (a*b)) {
            System.out.println(-1);
            return;
        }

        int num = 1;
        int [][] m = new int[a][b];


        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++ ) {
                if (num > n) { break; }
                if (i % 2 == 1) {
                    m[i][b - j - 1] = num;
                    num++;
                    continue;
                }
                m[i][j] = num;
                num++;
            }
        }
        //output
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++ ) {
                System.out.print(m[i][j] + " ");
            }
            System.out.println();
        }
    }
}
