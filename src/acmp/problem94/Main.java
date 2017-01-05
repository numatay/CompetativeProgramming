package acmp.problem94;

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
    int m = in.nextInt();
    int k = in.nextInt();

    int ans;
    if (n >= m) {
      ans = 1;
      out.print(ans);
    } else {
      if (n <= k) {
        out.print("NO");
      } else {
        ans = (m - n + n - k - 1) / (n - k) + 1;
        out.print(ans);
      }
    }

    // release resources
    out.close();
  }
}
