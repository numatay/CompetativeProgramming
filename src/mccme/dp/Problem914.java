package mccme.dp;

import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by macnur on 4/28/16.
 */
public class Problem914 {
    public static void main(String[] args) {
        InputReader in = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int n = in.nextInt();
        int[] a = new int[n+3];

        a[0] = 0;
        a[1] = 3;
        a[2] = 8;

        for (int i = 3; i <= n; i++) {
            a[i] = 2*a[i-1] + 2*a[i-2];
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
