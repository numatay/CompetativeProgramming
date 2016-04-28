package mccme.dp;

import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by macnur on 4/29/16.
 */
public class Problem912a {
    static int[] a;
    public static void main(String args[]) {
        InputReader in = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int n = in.nextInt();
        a = new int[n+5];
        a[0] = 0;
        a[1] = 2;
        a[2] = 4;
        a[3] = 7;

        for (int i = 4, j = 0; i <= n; i++, j++) {
            a[i] = a[i-1] + a[i-2] + a[i-3];
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
