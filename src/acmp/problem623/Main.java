package acmp.problem623;

import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Created by @umatayn on 01/16/2017.
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

        int a = 0, b = 1, j = 0, sum = 0;

        while(j <= n) {
            sum = a + b;
            sum %= 100;
            b = a;
            a = sum;
            j++;
        }

        out.print(sum % 10);

        // release resources
        out.close();
    }
}
