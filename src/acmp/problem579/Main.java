package acmp.problem579;

import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 */

public class Main {
    public static void main(String[] args) {
        new Thread(null, () -> new Main().run(), "solution", 1 << 23).start();
    }

    public void run() {
        // initialize resources
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);


        int n = in.nextInt();
        int[] a = new int[n];

        int sumPos = 0, cntPos = 0;
        int sumNeg = 0, cntNeg = 0;

        for (int i = 0; i < n; i++) {
            int num = in.nextInt();
            a[i] = num;

            if (num > 0) {
                sumPos += num;
                cntPos++;
            } else if (num < 0) {
                sumNeg += num;
                cntNeg++;
            }
        }

        if (Math.abs(sumNeg) >= sumPos) {
            System.out.println(cntNeg);
            for (int i = 0; i < n; i++) {
                if (a[i] < 0) {
                    System.out.print((i+1) + " ");
                }
            }
        } else {
            System.out.println(cntPos);
            for (int i = 0; i < n; i++) {
                if (a[i] > 0) {
                    System.out.print((i+1) + " ");
                }
            }
        }

        // release resources
        out.close();
    }
}