package acmp.problem685;

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

        int a1 = in.nextInt();
        int a2 = in.nextInt();
        int a3 = in.nextInt();
        int b1 = in.nextInt();
        int b2 = in.nextInt();
        int b3 = in.nextInt();

        int p1 = Math.max(a1, Math.max(a2, a3));
        int p3 = Math.min(a1, Math.min(a2, a3));

        int v1 = Math.max(b1, Math.max(b2, b3));
        int v3 = Math.min(b1, Math.min(b2, b3));

        int p2 = a1 + a2 + a3 - p1 - p3;
        int v2 = b1 + b2 + b3 - v1 - v3;

        out.print(p1 * v1 + p2 * v2 + p3 * v3);

        // release resources
        out.close();
    }
}