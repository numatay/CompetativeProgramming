package mccme.dp;

import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by Nurgissa on 5/7/2016.
 */
public class Problem945 {
    private static final int N = 8;
    public static void main(String[] args) {
        InputReader in = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int x = in.nextInt();
        int y = in.nextInt();

        int[][] b = new int[N][N+2];

        for (int i = 1; i <= N; i++) { b[0][i] = 1; }

        for (int i = 1; i < N; i++) {
            for (int j = 1; j <= N; j++) {
                b[i][j] = b[i-1][j-1] + b[i-1][j+1];
            }
        }

        out.println(b[Math.abs(N-y)][x]);

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
