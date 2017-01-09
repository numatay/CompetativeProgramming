package acmp.problem81;

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
    int smallest = Integer.MAX_VALUE, biggest = Integer.MIN_VALUE;

    int n = in.nextInt();
    for (int i = 0; i < n; i++) {
      int w = in.nextInt();
      smallest = Math.min(smallest, w);
      biggest = Math.max(biggest, w);
    }

    out.println(smallest + " " + biggest);

    // release resources
    out.close();
  }
}
