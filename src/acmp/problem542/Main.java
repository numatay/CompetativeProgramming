package acmp.problem542;

import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Created by umatayn on 01/16/2017.
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
        int incr = (int) (Math.log(n)/Math.log(2));

        while(n >= 2) {
            int r = n % 2;
            n /= 2;
            ans += (r << incr);
            incr--;
        }

        out.print(ans + (n << incr));

        // release resources
        out.close();
    }
}