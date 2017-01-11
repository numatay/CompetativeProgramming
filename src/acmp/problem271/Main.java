package acmp.problem271;

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

    int a = 0, b = 1, c = 0;
    int i = 0;

    while (c < n) {
      c = a + b;
      b = a;
      a = c;
      i++;
    }

    if (c == n) {
      out.print("1\n" + i);
    } else {
      out.print(0);
    }

    out.close();
  }
}
