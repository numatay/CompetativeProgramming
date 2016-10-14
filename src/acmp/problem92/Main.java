package acmp.problem92;

import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Created by @umatayn on 10/14/2016.
 */
public class Main {
  public static void main(String[] args) {
    new Thread(null, new Runnable() {
      @Override
      public void run() { new Main().run(); }
    }, "solution", 1<<23).start();
  }

  public void run() {
    // initialize resources
    Scanner in = new Scanner(System.in);
    PrintWriter out = new PrintWriter(System.out);

    // solution
    int s = in.nextInt();

    /*
      s = 2 * 2 * x + 2 * x
      s = 6 * x;
      x = s / 6;
     */

    int unit = s / 6;

    out.print(String.format("%d %d %d", unit, 2 * unit * 2,  unit));

    // release resources
    out.close();
  }
}
