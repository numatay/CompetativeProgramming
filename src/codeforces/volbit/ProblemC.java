package codeforces.volbit;

import java.io.PrintWriter;
import java.util.Scanner;


/**
 * Created by umatayn on 11/1/16.
 */
public class ProblemC {
    public static void main(String[] args) {
        new Thread(null, new Runnable() {
            @Override
            public void run() {
                ProblemC.run();
            }
        }, "solution", 1 << 23).start();
    }

    public static void run() {
        // initialize resources
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        long n = in.nextLong();


        out.print(2 * (1L << n) - 2);

        // release resources
        out.close();
    }
}
