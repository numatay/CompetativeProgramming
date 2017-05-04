package acmp.problem354;

import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Created by @umatayn on 5/3/2017.
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
        int n = in.nextInt();
        int prime = 2;
        String s = "";

        for (int i = 2; i <= Math.sqrt(n); i++) {
            while (n % i == 0) {
                n /= i;
                s += i + "*";

            }
        }

        if (n == 1) {
            out.print(s.substring(0, s.length()-1));
        } else {
            out.print(s + n);
        }

        // release resources
        out.close();
    }
}
