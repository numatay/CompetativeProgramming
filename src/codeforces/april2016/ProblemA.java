package codeforces.april2016;

import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by macnur on 4/1/16.
 */
public class ProblemA {

    public static void main(String[] args) {
        // initialize resources
        InputReader in = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);

        // solution
        int a = in.nextInt();


        long sum = 1;
        for (int i = 0; i < a; i++)
            sum *= 2;

        out.print(sum);

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
