package acmp.problem1115;

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

        int n = in.nextInt();
        int k = in.nextInt();

        int divideFloor = k / n;
        int divideCeil = (k + n - 1 ) / n;
        out.print(divideFloor + " ");
        out.print(k % n + " ");
        out.print((divideCeil * n - divideFloor * n) - (k % n));

        // release resources
        out.close();
    }

}
