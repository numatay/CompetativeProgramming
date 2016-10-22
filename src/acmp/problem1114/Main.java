package acmp.problem1114;

import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Created by umatayn on 10/16/16.
 */
public class Main {
    public static void main(String[] args) {
        new Thread(null, new Runnable() {
            @Override
            public void run() { new Main().run(); }
        }, "solution", 1<<23).start();
    }

    public void run() {
        // initialize resources
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int v = in.nextInt();
        int t = in.nextInt();
        final int s = 109;

        int res;

        res = (((v*t) % s + s) % s) + 1;

        out.println(res);

        // release resources
        out.close();
    }
}
