package vstu.problem819;

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

//        long corners = 4;
//        long side = (n-2) * 4;
//        long inner = (n * n) - side - corners;
//        long total = n * n;
//
//        out.print((total - 4) * corners
//            + (total - 6) * side
//            + (total - 9) * inner);

        out.print(1L * n * n * n * n - (3 * n - 2) * (3 * n - 2));

        out.close();
    }
}
