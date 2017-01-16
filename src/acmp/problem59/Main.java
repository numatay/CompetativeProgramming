package acmp.problem59;

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
        int k = in.nextInt();

        int l, sum = 0, prod = 1;

        while(n >= k) {
            l = n % k;
            n /= k;
            prod *= l;
            sum += l;
        }
        prod *= n;
        sum += n;
        out.print(prod - sum);

        // release resources
        out.close();
    }
}