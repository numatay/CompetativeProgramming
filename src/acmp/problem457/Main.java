package acmp.problem457;

import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Created by @umatayn on 1/13/2017.
 */
public class Main {
    public static void main(String[] args) {
        new Thread(null, () -> new Main().run(), "solution", 1 << 23).start();
    }

    public void run() {
        // initialize resources
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        // solution
        int n = in.nextInt();

        int cnt = 0;
        int delta, x = n;
        while (true) {
            int d4 = x % 10;
            int d3 = (x / 10) % 10;
            int d2 = (x / 100) % 10;
            int d1 = x / 1000;

            if (d1 < d2) {
                d1 = d1 ^ d2;
                d2 = d1 ^ d2;
                d1 = d1 ^ d2;
            }
            if (d3 < d4) {
                d3 = d3 ^ d4;
                d4 = d3 ^ d4;
                d3 = d3 ^ d4;
            }
            if (d1 < d3) {
                d1 ^= d3;
                d3 ^= d1;
                d1 ^= d3;
            }
            if (d2 < d3) {
                d2 ^= d3;
                d3 ^= d2;
                d2 ^= d3;
            }
            if (d3 < d4) {
                d3 ^= d4;
                d4 ^= d3;
                d3 ^= d4;
            }
            if (d2 < d3) {
                d2 ^= d3;
                d3 ^= d2;
                d2 ^= d3;
            }

            int numDesc = d1 * 1000 + d2 * 100 + d3 * 10 + d4;
            int numAcs = d4 * 1000 + d3 * 100 + d2 * 10 + d1;
            delta = numDesc - numAcs;
            if (delta == x) {
                break;
            }
            cnt++;
            x = delta;
        }

        out.print(x + "\n" + cnt);

        // release resources
        out.close();
    }
}
