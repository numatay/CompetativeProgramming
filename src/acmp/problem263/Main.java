package acmp.problem263;

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
        int i = in.nextInt();
        int j = in.nextInt();

        int ii = Math.min(i, j);
        int jj = Math.max(i, j);

        int lhs = jj - ii - 1;
        int rhs = n - jj + ii - 1;

        out.print(Math.min(lhs, rhs));

        // release resources
        out.close();
    }
}