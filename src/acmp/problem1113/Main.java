package acmp.problem1113;

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

        int a = in.nextInt();
        int b = in.nextInt();

        int c = Math.max(a, b) % Math.min(a, b);
        out.print(c + 1);

        out.close();
    }
}
