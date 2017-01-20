package acmp.problem316;

import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Created by @umatayn on 1/20/2017.
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
        int mult = n / 107;
        int rmnd = n % 107;
        int sum = 0;
        int fee = 0;

        if (rmnd > 7) {
            sum += rmnd - 7;
            fee += 7;
        }

        sum += (mult * 100);
        fee += (n / 107) * 7;
        out.print(sum + " " + fee);

        /* Editorial solution

            if (n % 107 <= 7) {
                out.println((n / 107) * 100 + " " + (n / 107 * 7));
            } else {
                out.println(((n / 107) * 100 + n % 107 - 7) + " " + ((n / 107) * 7 + 7));
            }

         */

        // release resources
        out.close();
    }
}
