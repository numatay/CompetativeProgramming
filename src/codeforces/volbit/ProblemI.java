package codeforces.volbit;

import java.io.PrintWriter;
import java.util.Scanner;


/**
 * Created by umatayn on 11/1/16.
 */
public class ProblemI {
    public static void main(String[] args) {
        new Thread(null, new Runnable() {
            @Override
            public void run() {
                ProblemI.run();
            }
        }, "solution", 1 << 23).start();
    }

    public static void run() {
        // initialize resources
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        long n = in.nextLong();

        out.print((9 * n - 3) << (2*n - 6));

        // release resources
        out.close();
    }
}
