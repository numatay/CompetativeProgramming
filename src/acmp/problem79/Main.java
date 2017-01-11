package acmp.problem79;

import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Created by @umatayn on 1/11/2017.
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

    long prod = 1;
    for (int i = 0; i < b; i++) {
      prod *= a;
      prod %= 10;
    }

    out.print(prod);

    // release resources
    out.close();
  }
}
