package acmp.problem330;

import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Created by @umatayn on 1/20/2017.
 */
public class Main {
    public static void main(String[] args) {
        new Thread(null,
                () -> new Main().run(), "solution", 1 << 23).start();
    }

    public void run() {
        // initialize resources
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int x1 = in.nextInt();
        int y1 = in.nextInt();

        int x2 = in.nextInt();
        int y2 = in.nextInt();

        if ((x1 + y1) % 2 == (x2 + y2) % 2) {
            if ((x1 + y1 == x2 + y2) || (Math.abs(x1 - y1) == Math.abs(x2 - y2))) {
                out.print(1);
            } else {
                out.print(2);
            }
        } else {
            out.print(0);
        }

        /* Editorial solution
            if (Math.abs(x1 - x2) == Math.abs(y1 - y2)) {
                out.println(1);
            } else if ((x1 + y2 + x2 + y2) % 2 != 0) {
                out.println(0);
            } else {
                out.println(2);
            }
         */

        out.close();
    }
}
