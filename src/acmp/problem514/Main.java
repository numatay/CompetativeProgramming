package acmp.problem514;

import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Created by umatayn on 1/11/2017.
 */
public class Main {
    public static void main(String[] args) {
        new Thread(null, () -> run(), "solution", 1 << 23).start();
    }

    public static void run() {
        // initialize resources
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int n = in.nextInt();

        int res = 0;
        for (int i = 0; 2 * n >= i * i + i; i++) {
            res = i;
        }

        out.print(res);

        // release resources
        out.close();
    }
}
