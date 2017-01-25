package acmp.problem246;

import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Created by umatayn on 01/25/2017.
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
        int prev = -1, cur;

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            cur = in.nextInt();
            if ((prev != -1) && (prev > cur || (cur - prev > 1))) {
                cnt++;
            }
            prev = cur;
        }

        out.print(cnt);

        // release resources
        out.close();
    }
}