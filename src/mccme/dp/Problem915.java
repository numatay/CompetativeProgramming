package mccme.dp;

import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by macnur on 4/28/16.
 */
public class Problem915 {
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
            b[i] = a[i];
        }


        for (int i = 3; i <= n; i++) {
            b[i] = a[i] + Math.min(b[i-1], b[i-2]);
        }

        out.println(Math.min(b[n-1] + a[n], b[n]));

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
