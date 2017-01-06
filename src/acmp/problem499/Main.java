package acmp.problem499;

import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Created by @umatayn on 10/14/2016.
 */
public class Main {
  public static void main(String[] args) {
    new Thread(null, () -> new Main().run(), "solution", 1<<23).start();
  }

  public void run() {
    // initialize resources
    Scanner in = new Scanner(System.in);
    PrintWriter out = new PrintWriter(System.out);

    // solution
    int k = in.nextInt();
    int w = in.nextInt();

    int a1 = in.nextInt();
    int b1 = in.nextInt();

    int a2 = in.nextInt();
    int b2 = in.nextInt();

    int a3 = in.nextInt();
    int b3 = in.nextInt();

    if ((a1 <= w && b1 >= k) || (a2 <= w && b2 >= k) || (a3 <= w && b3 >= k)) {
      out.print("YES");
    } else if (a1 + a2 <= w && b1 + b2 >= k) {
      out.print("YES");
    } else if (a1 + a3 <= w && b1 + b3 >= k) {
      out.print("YES");
    } else if (a2 + a3 <= w && b2 + b3 >= k) {
      out.print("YES");
    } else if (a1 + a2 + a3 <= w && b1 + b2 + b3 >= k) {
      out.print("YES");
    } else {
      out.print("NO");
    }

      // release resources
    out.close();
  }
}
