package acmp.problem651;

import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by macnur on 02/12/2017.
 */
public class Main {
    public static void main(String[] args) {
        new Thread(null, () -> new Main().run(), "solution", 1 << 23).start();
    }

    private void solve(InputReader in, PrintWriter out) {
        int n = in.nextInt();
        int m = in.nextInt();

        if (n == m) {
            out.print(0);
            return;
        }

        int maxVal = Math.max(n, m);
        int minVal = Math.min(n, m);
        int cnt = 0;

        for (int i = 2; i <= Math.sqrt(minVal); i++) {
            while (minVal % i == 0) {
                minVal /= i;

                if (maxVal % i == 0) {
                    maxVal /= i;
                } else {
                    cnt++;
                }
            }
        }

        if (minVal != 1) {
            if (maxVal % minVal == 0) {
                maxVal /= minVal;
            } else {
                cnt++;
            }
        }

        for (int i = 2; i <= Math.sqrt(maxVal); i++) {
            while (maxVal % i == 0) {
                maxVal /= i;
                cnt++;
            }
        }

        if (maxVal != 1) {
            cnt++;
        }

        out.print(cnt);

        // release resources
        out.close();
    }

    public void run() {
        // initialize resources
        InputReader in = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);

        solve(in, out);

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
