package acmp.problem148;

import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Created by @umatayn on 10/14/2016.
 */
public class Main {
  public static void main(String[] args) {
    // initialize resources
    Scanner in = new Scanner(System.in);
    PrintWriter out = new PrintWriter(System.out);

    // solution
    long a = in.nextLong();
    long b = in.nextLong();

    while (b != 0) {
      long t = b;
      b = a % b;
      a = t;
    }

    out.print(a);

    out.close();
  }

  public static long gcd(long a, long b) {
    if (b == 0) {
      return a;
    } else {
      return gcd(b, a % b);
    }
  }
}

