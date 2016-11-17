package acmp.problem513;

import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Created by @umatayn on 11/17/2016.
 */

  public class Main {
    public static void main(String[] args) {
      new Thread(null, new Runnable() {
        @Override
        public void run() {
          new Main().run();
        }
      }, "solution", 1 << 23).start();
    }

    public void run() {
      // initialize resources
      Scanner in = new Scanner(System.in);
      PrintWriter out = new PrintWriter(System.out);

      int n = in.nextInt();

      out.print((1L << n) - (n + 1));
      out.close();
    }
}
