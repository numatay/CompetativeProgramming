package acmp.problem285;

import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by macnur on 28/01/17.
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
        int n = in.nextInt();
        int m = in.nextInt();

        int max = 0, sum = 0;

        for (int i = 0; i < n; i++) {
            int val = in.nextInt();
            max = Math.max(max, val);
            sum += (val-1);
        }

        if (max > m || (sum < m-1)) {
            out.print("no");
        } else {
            out.print("yes");
        }

        /* Editorial solution

            if (max <= m && m <= (sum - (n - 1))) {
                out.print("yes");
            } else {
                out.print("no");
            }

         */

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
