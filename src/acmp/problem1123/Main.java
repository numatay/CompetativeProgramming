package acmp.problem1123;

import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Created by @umatayn on 01/07/2017.
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

        int d1 = Math.abs(x1 - x2);
        int d2 = Math.abs(y1 - y2);


        if ((d1 == 1 && d2 == 2) || (d1 == 2 && d2 == 1)) {
            out.print("YES");
        } else {
            out.print("NO");
        }

        // release resources
        out.close();
    }
}
