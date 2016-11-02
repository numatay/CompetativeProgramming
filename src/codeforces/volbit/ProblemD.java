package codeforces.volbit;

import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Created by umatayn on 11/2/16.
 */
public class ProblemD {
    public static void main(String[] args) {
        new Thread(null, new Runnable() {
            @Override
            public void run() {
                ProblemD.run();
            }
        }, "solution", 1 << 23).start();
    }

    public static void run() {
        // initialize resources
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        long n = in.nextLong();
        n++;
        long sum = n * (2*1 + (n-1)) / 2;

        out.print(6 * sum - 6 * n + 1);

        // release resources
        out.close();
    }
}
