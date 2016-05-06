package mccme.dp;

import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by Nurgissa on 5/6/2016.
 */
public class Problem2963 {
    public static void main(String[] args) {
        InputReader in = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int n = in.nextInt();
        int[] a = new int[n+5];

        a[0] = 0;
        a[1] = 0;
        a[2] = 1;
        a[3] = 1;

        for (int i = 4; i <= n; i++) {
            a[i] = Math.min(Math.min(a[i/2] + 1 + (i%2), a[i-1] + 1), a[i/3] + 1 + (i % 3));
        }

        out.println(a[n]);

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
