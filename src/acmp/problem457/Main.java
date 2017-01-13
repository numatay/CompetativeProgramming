package acmp.problem457;

import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Created by @umatayn on 1/13/2017.
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

        int ascVal = 0;
        int descVal = 0;

        do {
            int mask = 0;
            int curVal = n;
            System.err.println("before curVal " + curVal);
            while (curVal > 0) {
                int lsb = curVal % 10;
                mask |= (1 << lsb);
                curVal /= 10;
            }
            System.err.println("after curVal " + curVal);
            System.err.println(mask);
            ascVal = 0;
            descVal = 0;
            for (int i = 0; i < 10; i++) {
                int checker = mask & (1 << i);
                if (checker == 1) {
                    ascVal += 7;
                    ascVal *= 10;
                }
            }
            System.err.println(ascVal);

        } while (false);

        // release resources
        out.close();
    }
}
