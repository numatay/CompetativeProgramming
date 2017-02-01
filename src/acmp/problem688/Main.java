package acmp.problem688;

import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by macnur on 1/02/17.
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
        long sx = in.nextInt();
        long sy = in.nextInt();

        long dx = in.nextInt();
        long dy = in.nextInt();

        long n  = in.nextInt();

        for (int i = 1; i <= n; i++) {
            long x = in.nextInt();
            long y = in.nextInt();

            long d1 = (sx - x) * (sx - x) + (sy - y) * (sy - y);
            long d2 = (dx - x) * (dx - x) + (dy - y) * (dy - y);

            if (d1 * 4 <= d2) {
                out.print(i);
                out.close();
                return;
            }
        }

        out.print("NO");

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
