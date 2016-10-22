package acmp.problem294;

import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Created by umatayn on 10/24/16.
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

        int k1 = in.nextInt();
        int l1 = in.nextInt();
        int m1 = in.nextInt();

        int k2 = in.nextInt();
        int l2 = in.nextInt();
        int m2 = in.nextInt();

        int lostBolts = (k1 * l1) / 100;
        int lostNuts = (k2 * l2) / 100;
        int remainedBolts = k1 - lostBolts;
        int remainedNuts = k2 - lostNuts;

        int lostPrice = lostBolts * m1 + lostNuts * m2
                + Math.max(0, remainedBolts - remainedNuts) * m1
                + Math.max(0, remainedNuts - remainedBolts) * m2;
        out.print(lostPrice);

        // release resources
        out.close();
    }
}
