package mccme.dp;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by macnur on 4/29/16.
 */
public class Problem912 {
    static int[] a;
    public static void main(String args[]) {
        InputReader in = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int n = in.nextInt();
        a = new int[n+5];
        Arrays.fill(a, Integer.MAX_VALUE);

        out.println(getSeq(n));


        // release resources
        out.close();
    }

    public static int getSeq(int n) {
        if (n < 3) {
            return (int)Math.pow(2, n);
        }
        if (n == 3) {
            return 7;
        }

        if (a[n-1] == Integer.MAX_VALUE) { a[n-1] = getSeq(n-1); }
        if (a[n-2] == Integer.MAX_VALUE) { a[n-2] = getSeq(n-2); }
        if (a[n-3] == Integer.MAX_VALUE) { a[n-3] = getSeq(n-3); }
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
