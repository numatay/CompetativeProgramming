package acmp.problem511;

import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Created by @umatayn on 11/17/2016.
 */

  public class Main {
    public static void main(String[] args) {
      new Thread(null, () -> new Main().run(), "solution", 1 << 23).start();
    }

    public void run() {
      // initialize resources
      Scanner in = new Scanner(System.in);
      PrintWriter out = new PrintWriter(System.out);

      int k = in.nextInt();
      if (k < 144) {
        int total = (k-1) * 10 / 2;
        out.print(total / 60 + " " + total % 60);
      } else {
        out.print("NO");
      }

      out.close();
    }
}
