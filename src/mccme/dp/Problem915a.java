package mccme.dp;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by macnur on 4/28/16.
 */
public class Problem915a {
    private static int[] a;
    private static int[] b;
    public static void main(String[] args) {
        InputReader in = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int n = in.nextInt();
        a = new int[n+1];
        b = new int[n+1];

        for (int i = 1; i <= n; i++) {
            a[i] = in.nextInt();
        }

        Arrays.fill(b, Integer.MAX_VALUE);

        out.println(getPath(n));

        // release resources
        out.close();
    }

    public static int getPath(int n) {
        if (n == 0) return 0;
        if (n == 1) return a[1];
        if (n == 2) return a[2];
        if (b[n-1] == Integer.MAX_VALUE) { b[n-1] = getPath(n-1); }
        if (b[n-2] == Integer.MAX_VALUE) { b[n-2] = getPath(n-2); }

        return a[n] + Math.min(b[n-1], b[n-2]);
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
