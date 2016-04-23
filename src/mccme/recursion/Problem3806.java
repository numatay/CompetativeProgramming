package mccme.recursion;

import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by macnur on 4/24/16.
 */
public class Problem3806 {

    public static void main(String[] args) {
        InputReader in = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);

        double a = in.nextDouble();
        int n = in.nextInt();

        out.println(fastPow(a, n));

        // release resources
        out.close();
    }

    private static double fastPow(double a, int n) {
        if (n == 0) {
            return 1;
        } else if (n == 1) {
            return a;
        }

        if ((n & 1) == 0) {
            return fastPow(a*a, n/2);
        } else {
            return a * fastPow(a, n-1);
        }
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

        public double nextDouble() { return Double.parseDouble(next()); }
    }
}
