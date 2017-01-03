package acmp.problem8;

import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Created by umatayn on 01/04/2017.
 */
public class Main {
    public static void main(String[] args) {
        new Thread(null, () -> new Main().run(), "solution", 1 << 23).start();
    }

    public void run() {
        // initialize resources
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int a = in.nextInt();
        int b = in.nextInt();
        int c = in.nextInt();

        if (a * b == c) {
            out.print("YES");
        } else {
            out.print("NO");
        }

        // release resources
        out.close();
    }
}