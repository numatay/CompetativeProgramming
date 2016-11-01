package codeforces.volbit;

import java.io.PrintWriter;
import java.util.Scanner;


/**
 * Created by umatayn on 11/1/16.
 */
public class ProblemL {
    public static void main(String[] args) {
        new Thread(null, new Runnable() {
            @Override
            public void run() {
                ProblemL.run();
            }
        }, "solution", 1 << 23).start();
    }

    public static void run() {
        // initialize resources
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int n = in.nextInt();

        final int d = 100000;
        int fifth = n % 10;
        n /= 10;
        int fourth = n % 10;
        n /= 10;
        int third = n % 10;
        n /= 10;
        int second = n % 10;
        n /= 10;
        int first = n;

        long m = first;
        m *= 10;
        m += third;
        m *= 10;
        m += fifth;
        m *= 10;
        m += fourth;
        m *= 10;
        m += second;

        out.print(String.format("%05d",((((m * m * m) % d) * ((m * m) %d)) % d)));

        // release resources
        out.close();
    }
}
