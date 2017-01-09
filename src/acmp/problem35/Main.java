package acmp.problem35;

import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Created by @umatayn on 10/14/2016.
 */
public class Main {
  public static void main(String[] args) {
    new Thread(null,
            () -> new Main().run(), "solution", 1 << 23).start();
  }

  public void run() {
    // initialize resources
    Scanner in = new Scanner(System.in);
    PrintWriter out = new PrintWriter(System.out);

    // solution
    int k = in.nextInt();
    for (int i = 0; i < k; i++) {
      long n = in.nextLong();
      long m = in.nextLong();

      out.println(19 * m + (n + 239) * (n + 366) / 2);
    }

    // release resources
    out.close();
  }
}
