package acmp.problem1118;

import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Created by @umatayn on 10/25/2016.
 */
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

    int h = in.nextInt();
    int a = in.nextInt();
    int b = in.nextInt();


    int days = ((h - a) + (a - b) - 1) / (a - b) + 1;

    out.print(Math.max(days, 1));

    // release resources
    out.close();
  }
}
