package acmp.problem464;

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

        n--;

        long m = 0;
        while(n > 0) {
            if (n % 2 != 0) {
                m++;
            }
            n /= 2;
        }

        out.print(m % 3);

        // release resources
        out.close();
    }
}
