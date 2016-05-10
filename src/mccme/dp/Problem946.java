package mccme.dp;

import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by macnur on 5/8/16.
 */
public class Problem946 {
    public static void main(String[] args) {
        InputReader in = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int n = in.nextInt();
        int m = in.nextInt();
        int[][] dp = new int[n+1][m+1];

        dp[1][1] = 1;
        for (int i = 2; i < n+1; i++) {
            for (int j = 2; j < m+1; j++) {
                dp[i][j] = dp[i-2][j-1] + dp[i-1][j-2];
            }
        }


        out.println(dp[n][m]);


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
