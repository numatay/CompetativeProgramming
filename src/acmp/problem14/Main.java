package acmp.problem14;

import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Created by @umatayn on 01/16/2017.
 */
public class Main {
    public static void main(String[] args) {
        new Thread(null,
                () -> new Main().run(), "solution", 1 << 23).start();
    }

    public void run() {
        // initialize resources
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        long a = in.nextLong();
        long b = in.nextLong();

        long nok = a * b;

        long d = Math.max(a, b);
        long ans = nok;

        while(nok > d) {
            nok -= d;
            if (nok % a == 0 && nok % b == 0) {
                ans = nok;
            }
        }

        /* Editorial solution

            int p = a * b;
            while(b != 0) {
                int t = a % b;
                a = b;
                b = t;
            }

            out.println(p / a);

         */

        out.print(ans);

        // release resources
        out.close();
    }
}
