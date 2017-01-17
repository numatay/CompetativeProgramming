package acmp.problem118;

import java.io.*;
import java.util.StringTokenizer;

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
    InputReader in = new InputReader(System.in);
    PrintWriter out = new PrintWriter(System.out);

    // solution
    long a, b, c, d, e, f, g, h, i, j;
    a = b = c = d = e = f = g = h = i = j = Long.MAX_VALUE;

    int n = in.nextInt();
    int k = in.nextInt();

    int left = n;

    int jj = 0;
    while (left > 0) {
      int kk = k;
      while (kk > 0) {
        out.println(jj);
        out.println("a="+a);
        long offset = (1L << jj);
        long checker = a & offset;
        out.println("checker " + checker);
        out.println("kk " + kk);
        if (checker != 0) {
          kk--;
        }
//        } else if (j > 50 && j <= 100) {
//
//        } else if (j > 100 && j <= 150) {
//
//        } else if (j > 150 && j <= 200) {
//
//        } else if (j > 200 && j <= 250) {
//
//        } else if (j > 250 && j <= 300) {
//
//        } else if (j > 300 && j <= 350) {
//
//        } else if (j > 350 && j <= 400) {
//
//        } else if (j > 400 && j <= 450) {
//
//        } else if (j > 450 && j <= 500) {
//
//        } else {jj = 1;
//
//        }
        jj++;
        jj %= (n+1);
      }
      a |= (1L << jj);
      out.println("Deleting " + jj);
      left--;
      out.println("a " + Math.log(a)/Math.log(2));
      out.println(jj);
    }


    // release resources
    out.close();
  }

  static class InputReader {
    public BufferedReader reader;
    public StringTokenizer tokenizer;

    public InputReader(InputStream stream) {
      reader = new BufferedReader(new InputStreamReader(stream), 32768);
      tokenizer = null;
    }

    public String next() {
      while (tokenizer == null || !tokenizer.hasMoreTokens()) {
        try {
          tokenizer = new StringTokenizer(reader.readLine());
        } catch (IOException e) {
          throw new RuntimeException(e);
        }
      }
      return tokenizer.nextToken();
    }

    public int nextInt() { return Integer.parseInt(next()); }

    public long nextLong() { return Long.parseLong(next()); }
  }
}
