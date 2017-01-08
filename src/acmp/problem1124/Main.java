package acmp.problem1124;

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


        int d2 = y2 - y1;


        if (x1 == x2 && y1 > 1) {
            if (d2 == 1 || (d2 == 2 && y2 == 4 && y1 == 2)) {
                out.print("YES");
            } else {
                out.print("NO");
            }
        } else {
            out.print("NO");
        }

        // release resources
        out.close();
    }
}
