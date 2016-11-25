package codeforces.volbit;

import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Created by @umatayn on 11/25/2016.
 */
public class ProblemG {
  public static void main(String[] args) {
    new Thread(null, new Runnable() {
      @Override
      public void run() {
        ProblemG.run();
      }
    }, "solution", 1 << 23).start();
  }

  public static void run() {
    // initialize resources
    Scanner in = new Scanner(System.in);
    PrintWriter out = new PrintWriter(System.out);

    long n = in.nextInt();

    long combBug = n * (n+1) * (n+2) / 6;
    long combFeature = n * (n+1) * (n+2) * (n+3) * (n+4) / 120;

    out.print(combBug * combFeature);

    // release resources
    out.close();
  }
}
