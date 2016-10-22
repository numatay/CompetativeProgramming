package acmp.problem1116;

import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Created by umatayn on 10/22/16.
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

        int h1 = in.nextInt();
        int m1 = in.nextInt();
        int s1 = in.nextInt();

        int h2 = in.nextInt();
        int m2 = in.nextInt();
        int s2 = in.nextInt();

        int t1 = s1 + m1 * 60 + h1 * 60 * 60;
        int t2 = s2 + m2 * 60 + h2 * 60 * 60;

        out.print(t2 - t1);
        // release resources
        out.close();
    }
}
