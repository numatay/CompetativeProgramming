package acmp.problem539;

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

        int ans = 0;
        if (n % 2 == 1 && n != 1) {
            ans = n;
        } else if (n % 2 == 0) {
            ans = n / 2;
        }

        out.print(ans);

        // release resources
        out.close();
    }
}