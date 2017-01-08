package acmp.problem1121;

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



        if ((x1 == x2 || y1 == y2) || d1 == d2) {
            out.print("YES");
        } else {
            out.print("NO");
        }

        // release resources
        out.close();
    }
}
