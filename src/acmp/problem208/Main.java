package acmp.problem208;

import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Created by umatayn on 01/25/2017.
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

        int shifts = (int) (Math.log(n) / Math.log(2));

        int max = 0;
        for (int i = 0; i <= shifts; i++) {
            int lsb = n & 1;
            n >>= 1;
            n |= (lsb << shifts);
            max = Math.max(max, n);
        }

        out.print(max);

        /* Editorial solution

            int pow = 1;
            int max = n;
            while(pow * 2 < n) {
                pow *= 2;
            }

            int n0 = n;

            do {
                n = n / 2 + (n % 2) * pow;
                max = Math.max(max, n);
            } while(n != n0);

            out.print(max);
        */

        // release resources
        out.close();
    }
}