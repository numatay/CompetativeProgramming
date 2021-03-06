package acmp.problem528;

import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Created by umatayn on 11/2/16.
 */
public class Main {
    public static void main(String[] args) {
        new Thread(null, new Runnable() {
            @Override
            public void run() {
                Main.run();
            }
        }, "solution", 1 << 23).start();
    }

    public static void run() {
        // initialize resources
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        long n = in.nextLong();
        long k = in.nextLong();

        long sum = k * (2 * 2 + (k-1)) / 2;

        out.print(sum * (n - 2) - (n-3) * k + 1);


        // release resources
        out.close();
    }
}
