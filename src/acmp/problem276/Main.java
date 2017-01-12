package acmp.problem276;

import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Created by @umatayn on 1/11/2016.
 */
public class Main {
    public static void main(String[] args) {
        new Thread(null, () -> new Main().run(), "solution", 1 << 23).start();
    }

    public void run() {
        // initialize resources
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int n = in.nextInt();
        int m = in.nextInt();

        int r = n % m;
        int rlim = n / m;
        int llim = m - r;



        for (int i = 0; i < m; i++) {
            int inc = 0;
            if (i >= llim && r != 0) {
                inc = 1;
            }
            out.print((n / m) + inc + " ");
        }

        out.close();
    }
}
