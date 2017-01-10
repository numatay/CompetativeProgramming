package acmp.problem496;

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
    int n = in.nextInt();

    int first = in.nextInt();
    int second = in.nextInt();

    int tuple1 = first + second;
    int tuple2 = 0;
    int max = 0;

    int a = first, b = second;
    int x = 0;
    for (int i = 2; i < n; i++) {
      x = in.nextInt();
      if (n-2 == i || i == n-1) {
        tuple2 += x;
      }
      max = Math.max(max, a + b + x);
      a = b;
      b = x;
    }

    out.println(Math.max(max, Math.max(tuple1 + x, tuple2 + first)));


    // release resources
    out.close();
  }
}
