package mccme.dp;

import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by Nurgissa on 5/7/2016.
 */
public class Problem944 {
    public static void main(String[] args) {
        InputReader in = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int n = in.nextInt();
        int m = in.nextInt();

        int[][] map = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = in.nextInt();
            }
        }

        // preprocessing
        for (int i = 1; i < n; i++) { map[i][0] += map[i-1][0]; }
        for (int i = 1; i < m; i++) { map[0][i] += map[0][i-1]; }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                map[i][j] += Math.min(map[i-1][j], map[i][j-1]);
            }
        }

        out.println(map[n-1][m-1]);


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
