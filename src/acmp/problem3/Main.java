package acmp.problem3;

import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Created by umatayn on 10/22/16.
 */
public class Main {
    public static void main(String[] args) {
        new Thread(null, new Runnable() {
            @Override
            public void run() {
                new Main().run();
            }
        }, "solution", 1 << 23).start();
    }

    public void run() {
        // initialize resources
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int n = in.nextInt();
        long prefixN = n / 10;
        int suffixN = n % 10;
        long sum = prefixN * (prefixN + 1) * 100 + suffixN * suffixN;

        out.print(sum);

        // release resources
        out.close();

    }
}
