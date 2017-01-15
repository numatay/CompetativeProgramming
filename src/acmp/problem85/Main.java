package acmp.problem85;

import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Created by @umatayn on 01/15/2017.
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

        while (m > 0) {
            int a = m;
            m = n % m;
            n = a;
        }

        for (int i = 0; i < n; i++) {
            out.print(1);
        }
        // release resources
        out.close();
    }
}
