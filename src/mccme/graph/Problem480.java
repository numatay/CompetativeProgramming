package mccme.graph;

import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by @umatayn on 9/2/2016.
 */
public class Problem480 {
    public static void main(String[] args) {
        // initialize resources
        InputReader in = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);

        // solution
        int n = in.nextInt();
        int[][] a = new int[n+1][n+1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                int val = in.nextInt();

                if (val == 1) {
                    a[i][j]++;
                }

            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                int u = i;
                int v = j;

                if (i == j || a[u][v] == 0) { continue; }

                for (int w = j+1; w <= n; w++) {
                    if (w == u || w == v) { continue; }
                    int sum = a[u][w] + a[v][w];
                    if (sum == 2 || sum == 0) {

                        continue;
                    } else {
//                        System.out.println(a[u][w] + ":" + a[v][w]);
//                        System.out.println("u=" + u + "v=" + v + "w=" + w);
                        System.out.println("NO");
                        return;
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