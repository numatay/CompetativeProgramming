package acmp.problem1038;

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

    int n = in.nextInt();

    out.print((n / 10) + ((n % 10 + 9) / 10));
    // release resources
    out.close();
  }
}
