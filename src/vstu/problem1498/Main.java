package vstu.problem1498;

import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Created by umatayn on 11/18/16.
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

        int n = in.nextInt();

        out.print(n * n + n * n - n);

        // release resource
        out.close();
    }
}
