package acmp.problem4;

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
    int i = in.nextInt();

    out.print(String.format("%d%d%d", i, 9, 9 - i));

    // release resources
    out.close();
  }

}
