package acmp.problem62;

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

        String pos = in.next();
        int x = pos.charAt(0) - 'A' + 1;
        int y = pos.charAt(1) - '0';

        if ((x % 2 == 1 && y % 2 == 0) || (x % 2 == 0 && y % 2 == 1)) {
            out.print("WHITE");
        } else {
            out.print("BLACK");
        }



        // release resources
        out.close();
    }
}
