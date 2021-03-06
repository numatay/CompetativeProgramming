package codeforces.volbit;

import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.Scanner;


/**
 * Created by umatayn on 11/1/16.
 */
public class ProblemF {
    public static void main(String[] args) {
        new Thread(null, new Runnable() {
            @Override
            public void run() {
                ProblemF.run();
            }
        }, "solution", 1 << 23).start();
    }

    public static void run() {
        // initialize resources
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        long n = in.nextLong();

//        BigInteger b1 = BigInteger.valueOf(n);
//
//        BigInteger sum = b1.multiply(BigInteger.valueOf(n -1)).multiply(BigInteger.valueOf(n -2))
//                .multiply(BigInteger.valueOf(n -3)).multiply(BigInteger.valueOf(n -4)).multiply(BigInteger.valueOf(n*n - 4*n + 37)).divide(BigInteger.valueOf(5040));
//
//        out.print(sum.toString());

        /* answer */
        long cn5 = 1L * n * (n-1) * (n-2) * (n-3) * (n-4) / (1 * 2 * 3 * 4 * 5);
        long cn6 = cn5 * (n-5L) / 6;
        long cn7 = cn6 * (n-6L) / 7;


        out.print(cn5 + cn6 + cn7);

        // release resources
        out.close();
    }
}
