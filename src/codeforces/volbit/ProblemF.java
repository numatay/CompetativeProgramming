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

        BigInteger b1 = BigInteger.valueOf(n);

        BigInteger sum = b1.multiply(BigInteger.valueOf(n -1)).multiply(BigInteger.valueOf(n -2))
                .multiply(BigInteger.valueOf(n -3)).multiply(BigInteger.valueOf(n -4)).multiply(BigInteger.valueOf(n*n - 4*n + 37)).divide(BigInteger.valueOf(5040));



        //out.print((1L * n * (n-1) * (n-2) * (n-3) * (n-4) * (1L * n*n - 4 * n + 37))/5040);
        out.print(sum.toString());

        // release resources
        out.close();
    }
}
