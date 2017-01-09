package acmp.problem147;

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

        int n = in.nextInt();
        int p1 = 0;
        int p2 = 1;
        int s = 0;

        int i = 0;
        while (n >= 1 && i != n) {
            i++;
            s = p1 + p2;
            p2 = p1;
            p1 = s;
        }

        out.print(s);
        // release resources
        out.close();
    }
}
