package acmp.problem2;

/**
 * Created by @umatayn on 10/28/2016.
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

    int n = in.nextInt();
    int absN = Math.abs(n);
    int sum = n * (1 + absN) / 2 + 1;
    sum -= Math.min(0, sum  >> 31);


    out.print(sum);

    // release resources
    out.close();
  }
}