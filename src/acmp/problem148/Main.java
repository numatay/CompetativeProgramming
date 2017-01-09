package acmp.problem148;

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
    int a = in.nextInt();
    int b = in.nextInt();

    int limit = Math.min(a, Math.min(b, Math.abs(a - b)));
    int x = 1;
    for (int i = 1; i <= limit; i++) {
      if (a % i == 0 && b % i == 0) {
        x = i;
      }
    }

    out.print(x);

    // release resources
    out.close();
  }
}
