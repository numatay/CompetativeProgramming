package acmp.problem521;

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


        int p = in.nextInt();
        int k = in.nextInt();

        int steps = 0;
        for (int i = p; i <= k; i++) {
            int n = i;
            while (n > 2) {
                if (n % 2 == 0) {
                    n /= 2;
                } else {
                    n = (n * 3) + 1;
                }
                steps++;
            }
        }

        System.out.println(steps);




        /* ACCEPTED SOLUTION WITH ARRAY


        int[] a = new int[k - p + 1];

        for (int i = 0; i < a.length; i++) {
            a[i] = p + i;
        }

        int step = 0;

        while (true) {
            int stoppers = 0;
            for (int i = 0; i < a.length; i++) {
                if (a[i] == 2) {
                    stoppers++;
                    continue;
                } else if (a[i] % 2 == 0) {
                    a[i] /= 2;
                    step++;
                } else {
                    a[i] = (a[i] * 3 + 1);
                    step++;
                }
            }

            if (stoppers == a.length) {
                break;
            }
        }

        System.out.println(step);

        */
        // release resources
        out.close();
    }
}