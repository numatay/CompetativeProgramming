//package acmp.problem182;

import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by @umatayn on 1/21/2017.
 */

public class Main {
    public static void main(String[] args) {
        new Thread(null, () -> new Main().run(), "solution", 1 << 23).start();
    }

    public void run() {
        // initialize resources
        InputReader in = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);

        // solution
        int x1 = in.nextInt();
        int y1 = in.nextInt();

        int x2 = in.nextInt();
        int y2 = in.nextInt();

        int x3 = in.nextInt();
        int y3 = in.nextInt();

        int d12 = ((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
        int d13 = ((x1 - x3) * (x1 - x3) + (y1 - y3) * (y1 - y3));
        int d23 = ((x2 - x3) * (x2 - x3) + (y2 - y3) * (y2 - y3));

        int x4 = 0, y4 = 0;

        if (d12 + d13 == d23) {
            x4 = x3 + x2 - x1;
            y4 = y3 + y2 - y1;
        } else if (d12 + d23 == d13) {
            x4 = x1 + x3 - x2;
            y4 = y1 + y3 - y2;
        } else if (d13 + d23 == d12) {
            x4 = x2 + x1 - x3;
            y4 = y2 + y1 - y3;
        }

        out.print(x4 + " " + y4);


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

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }
    }
}
