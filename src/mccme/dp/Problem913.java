package mccme.dp;

import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by macnur on 4/28/16.
 */
public class Problem913 {
    static int[] a;

    public static void main(String[] args) {
        InputReader in = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int n = in.nextInt();
        a = new int[n+4];

        a[0] = 0;
        a[1] = 2;
        a[2] = 3;
        for (int i = 3; i <= n; i++) {
            a[i] = a[i-1] + a[i-2];
        }

        out.println(a[n]);

        // release resources
        out.close();
    }

    private static long cnk(int n, int k) {
        long top = 1, bot = 1;
        for (int i = k+1; i <= n; i++) {
            top *= i;
        }
        for (int i = 1; i <= n-k; i++) {
            bot *= i;
        }
        return top/bot;
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
