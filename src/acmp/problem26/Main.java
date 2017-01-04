//package acmp.problem26;

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

        int x1 = in.nextInt();
        int y1 = in.nextInt();
        int r1 = in.nextInt();

        int x2 = in.nextInt();
        int y2 = in.nextInt();
        int r2 = in.nextInt();

        int d = (int)Math.sqrt((x2 - x1)*(x2 - x1) + (y2 - y1)*(y2 - y1));
        int r = (r1 + r2);


        if (d <= r) {
            if (Math.max(r1, r2) > d + Math.min(r1, r2)) {
                out.print("NO");
            } else {
                out.print("YES");
            }
        } else if (d == 0) {
            if (r1 == r2) {
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