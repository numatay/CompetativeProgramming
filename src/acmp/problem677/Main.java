package acmp.problem677;

import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Created by @umatayn on 11/18/2016.
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

        int k = in.nextInt();
        int n = in.nextInt();
        int m = in.nextInt();
        int d = in.nextInt();

        int denom = k * n * m;
        int enom = k * n * m - n * m - k * m - k * n;

        int x = -1;

        if (enom != 0)
            x = (denom * d) / enom;

        if (x <= 0) {
            out.println(-1);
        } else {
            if ((x / k) * k != x || (x / n) * n != x || (x / m) * m != x) {
                out.print(-1);
            } else {
                out.println(x);
            }
        }

        out.close();
    }
}
