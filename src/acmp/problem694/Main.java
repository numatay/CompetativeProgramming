package acmp.problem694;

import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Created by @umatayn on 1/11/2016.
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
        int st, ed, latestStart = 1, earliestFinish = 31;

        for (int i = 0; i < n; i++) {
            st = in.nextInt();
            ed = in.nextInt();

            latestStart = Math.max(latestStart, st);
            earliestFinish = Math.min(earliestFinish, ed);

            if (st > earliestFinish || ed < latestStart) {
                out.print("NO");
                out.close();
                return;
            }
        }

        out.print("YES");

        // release resources
        out.close();
    }
}
