package mccme.dp;

import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by Nurgissa on 5/11/2016.
 */
public class Problem2962 {
    public static void main(String[] args) {
        InputReader in = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int n = in.nextInt();
        int m = in.nextInt();
        int[][] dp = new int[n][m];
        dp[0][0] = 1;
        // head
        for (int i = 1; i < n; i++) {
            for (int j = 0, w = i; j <= i; j++, w--) {
                dp[w][j] = getVal(dp, w-1,j-2) + getVal(dp, w-2,j-1) + getVal(dp, w-2, j+1) + getVal(dp, w+1, j-2);
            }
        }
        // mid
        for (int i = 1; i < m-n; i++) {
            for (int j = i, w = n-1; j < n+i; j++, w--) {
                dp[w][j] = getVal(dp, w-1,j-2) + getVal(dp, w-2,j-1) + getVal(dp, w-2, j+1) + getVal(dp, w+1, j-2);
            }
        }
        // tail
        for (int i = m-n; i < m; i++) {
            for (int j = i, w = n-1; j < m; j++, w--) {
                dp[w][j] = getVal(dp, w-1,j-2) + getVal(dp, w-2,j-1) + getVal(dp, w-2, j+1) + getVal(dp, w+1, j-2);
            }
        }

        out.println(dp[n-1][m-1]);

        // release resources
        out.close();
    }

    private static int getVal(int[][] a, int x, int y) {
        if (x < 0 || y < 0) return 0;
        if (x >= a.length || y >= a[0].length) return 0;
        return a[x][y];
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
