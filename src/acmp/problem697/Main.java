package acmp.problem697;

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

    int l = in.nextInt();
    int w = in.nextInt();
    int h = in.nextInt();

    int area = l * h * 2 + w * h * 2;

    out.print((area / 16) + ((area % 16 + 15) / 16));
    // release resources
    out.close();
  }
}
