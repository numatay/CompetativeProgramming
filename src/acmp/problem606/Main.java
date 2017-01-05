package acmp.problem606;

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

        int a = in.nextInt();
        int b = in.nextInt();
        int c = in.nextInt();

        if (a + b > c && a + c > b && b + c > a) {
            out.print("YES");
        } else {
            out.print("NO");
        }

        out.close();
    }
}
