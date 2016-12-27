package codeforces.volbit;

import java.io.PrintWriter;
import java.util.Scanner;


/**
 * Created by umatayn on 11/1/16.
 */
public class ProblemH {
    public static void main(String[] args) {
        new Thread(null, new Runnable() {
            @Override
            public void run() {
                ProblemH.run();
            }
        }, "solution", 1 << 23).start();
    }

    public static void run() {
        // initialize resources
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        long n = in.nextLong();

        long pm5 = n * (n-1) * (n-2) * (n-3) * (n-4);

        long cn5 = n * (n-1) * (n-2) * (n-3) * (n-4) / (1 * 2 * 3 * 4 * 5);

        out.print(pm5 * cn5);

        // release resources
        out.close();
    }
}
