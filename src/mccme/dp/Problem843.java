//package mccme.dp;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by macnur on 4/28/16.
 */
public class Problem843 {

    public static void main(String[] args) {
        InputReader in = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int n = in.nextInt();
        long[] a = new long[n+1];

        Arrays.fill(a, Integer.MAX_VALUE);
        out.println(getSeq(a, n));

        // release resources
        out.close();
    }

    public static long getSeq(long[] a, int n) {

        if (n == 0 || n == 1) { return 1; }

        long val = 0;

        if (a[n/2] == Integer.MAX_VALUE) { a[n/2] = getSeq(a, n/2); }
        if (a[n/2-1] == Integer.MAX_VALUE) { a[n/2 - 1] = getSeq(a, n/2 - 1); }

        if ((n & 1) == 0) {
            val = a[n/2] + a[n/2 - 1];
        } else {
            val = a[n/2] - a[n/2 - 1];
        }

        return val;
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
