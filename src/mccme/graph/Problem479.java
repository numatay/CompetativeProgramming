package mccme.graph;

import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by @umatayn on 9/2/2016.
 */
public class Problem479 {
    public static void main(String[] args) {
        // initialize resources
        InputReader in = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);

        // solution
        int n = in.nextInt();
        int[][] a = new int[n+1][n+1];

        int m = in.nextInt();

        for (int i = 0; i < m; i++) {
            int u = in.nextInt();
            int v = in.nextInt();
            a[u][v]++;
            a[v][u]++;
        }

        for (int i = 2; i <= n; i++) {
            for (int j = i; j <= n; j++) {
                if (a[i][j] == 1) {
                    int u = i;
                    int v = j;
                    for (int w = 1; w <= n; w++) {
                        if (w == u || w == v) { continue; }
                        if (a[u][w] != a[v][w]) {
                            System.out.println("NO");
                            return;
                        }
                    }
                }

            }
        }

        System.out.println("YES");

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