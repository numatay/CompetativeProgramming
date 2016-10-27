package acmtimus.problem1638;

/**
 * Created by @umatayn on 10/27/2016.
 */

import java.io.PrintWriter;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    new Thread(null, new Runnable() {
      @Override
      public void run() {
        Main.run();
      }
    }, "solution", 1 << 23).start();
  }

  public static void run() {
    // initialize resources
    Scanner in = new Scanner(System.in);
    PrintWriter out = new PrintWriter(System.out);

    int p = in.nextInt();
    int c = in.nextInt();
    int st = in.nextInt();
    int ed = in.nextInt();

    int path = Math.abs((2 * c + p) * (ed - st) - p);

    out.println(path);

    // release resources
    out.close();
  }
}
