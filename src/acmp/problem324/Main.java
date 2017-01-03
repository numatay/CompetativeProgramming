package acmp.problem324;

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

        int n = in.nextInt();

        int n1 = n % 10;
        int n2 = (n / 10) % 10;
        int n3 = (n / 100) % 10;
        int n4 = (n / 1000) % 10;

        if (n4 == n1 && n3 == n2) {
            out.print("YES");
        } else {
            out.print("NO");
        }

        // release resources
        out.close();
    }
}