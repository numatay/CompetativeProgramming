package acmp.problem667;

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

        int n = in.nextInt();
        int m = in.nextInt();
        int k = in.nextInt();

        int pNum = m / 2;
        int kNum = k - 2;

        if (kNum <= 0 || pNum * kNum < n) {
            out.print(0);
        } else {
            out.print((n + m + k - 1) / k);
        }


        out.close();
    }
}
