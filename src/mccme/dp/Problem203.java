package mccme.dp;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by macnur on 4/28/16.
 */
public class Problem203 {
    private static int a[];
    public static void main(String[] args) {
        InputReader in = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int n = in.nextInt();
        a = new int[n+1];
        Arrays.fill(a, Integer.MIN_VALUE);

        out.println(getPaths(n));

        // release resources
        out.close();
    }

    public static int getPaths(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        } else if (n == 3) {
            return 4;
        }

        if (a[n-1] == Integer.MIN_VALUE) { a[n-1] = getPaths(n-1); }
        if (a[n-2] == Integer.MIN_VALUE) { a[n-2] = getPaths(n-2); }
        if (a[n-3] == Integer.MIN_VALUE) { a[n-3] = getPaths(n-3); }

        return a[n-1] + a[n-2] + a[n-3];
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
