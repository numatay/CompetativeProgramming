package acmp.problem597;

import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Created by umatayn on 01/04/2017.
 */
public class Main {
    public static void main(String[] args) {
        new Thread(null, () -> new Main().run(), "solution", 1 << 23).start();
    }

    public void run() {
        // initialize resources
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        long r1 = in.nextLong();
        long r2 = in.nextLong();
        long r3 = in.nextLong();

        if (r1 < r2 + r3) {
            out.print("NO");
        } else {
            out.print("YES");
        }


        // release resources
        out.close();
    }
}