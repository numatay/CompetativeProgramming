package acmp.problem11;

import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by Nurgissa on 5/13/2016.
 */
public class Main {
    public static void main(String[] args) {
        InputReader in = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int k = in.nextInt();
        int n = in.nextInt();

        int[] dp = new int[n];

        int sum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < i+k; j++) {
                update(dp, j);
            }
            sum += dp[i];

        }

        for (int x : dp) {
            out.println(x);
        }

        // release resources
        out.close();
    }

    private static void update(int[] dp, int i) {
        if (i < 0 || i >= dp.length) return;
        dp[i]++;
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
