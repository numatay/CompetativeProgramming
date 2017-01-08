package acmp.problem763;

import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Created by @umatayn on 01/07/2017.
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

        int x1 = in.nextInt();
        int y1 = in.nextInt();

        if (x1 == 1 && y1 == 1) {
            out.print(0);
        } else if ((x1 == 1 || y1 == 1) || (x1 != y1)) {
            out.print(1);
        } else {
            out.print(2);
        }

        // release resources
        out.close();
    }
}
