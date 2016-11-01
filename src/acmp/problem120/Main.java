package acmp.problem120;

import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by Nurgissa on 5/16/2016.
 */
public class Main {
    public static void main(String[] args) {
        InputReader in = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int n = in.nextInt();
        int m = in.nextInt();

        int[][] a = new int[n][m];
        int[][] dp = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                a[i][j] = in.nextInt();
            }
        }
        int sum;
        dp[0][0] = sum = a[0][0];
        for (int i = 1; i < m; i++) { sum+=a[0][i]; dp[0][i] = sum; }
        sum = a[0][0];
        for (int i = 1; i < n; i++) { sum+=a[i][0]; dp[i][0] = sum; }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                dp[i][j] += a[i][j] + Math.min(dp[i - 1][j], dp[i][j - 1]);
            }
        }

        out.println(dp[n-1][m-1]);

        // release resources
        out.close();
    }

    private static void update(int[][] a, int n, int m) {
        if (n < 0 || n >= a.length) return;
        if (m < 0 || m >= a[0].length) return;

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
