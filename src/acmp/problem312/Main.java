package acmp.problem312;

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
      int a1 = in.nextInt();
      int a2 = in.nextInt();
      int d = a2 - a1;

      int nth = in.nextInt();

      out.print(a1 + d * (nth - 1));

      // release resources
      out.close();
    }
}
