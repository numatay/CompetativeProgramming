package acmp.problem52;

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

        int rhs1 = n % 10;
        int rhs2 = (n / 10) % 10;
        int rhs3 = (n / 100) % 10;

        int lhs1 = (n / 1000) % 10;
        int lhs2 = (n / 10000) % 10;
        int lhs3 = (n / 100000) % 10;

        int lhs = lhs1 + lhs2 + lhs3;
        int rhs = rhs1 + rhs2 + rhs3;

        if (rhs == lhs) {
            out.print("YES");
        } else {
            out.print("NO");
        }

        // release resources
        out.close();
    }
}