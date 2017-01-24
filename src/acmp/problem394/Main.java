package acmp.problem394;

import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Created by @umatayn on 1/24/2017.
 */
public class Main {

    public static void main(String[] args) {
        new Thread(null, () -> new Main().run(), "solution", 1 << 23).start();
    }

    public void run() {
        // initialize resources
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        // solution
        long n = in.nextLong();
        long m = in.nextLong();

        long a = n;
        long b = m;

        while (b != 0) {
            long t = a % b;
            a = b;
            b = t;
        }

        out.print(n / a);

        // release resources
        out.close();
    }

}
