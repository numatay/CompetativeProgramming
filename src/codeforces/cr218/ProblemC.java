package codeforces.cr218;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by ABiryulin on 1/30/2016.
 */
public class ProblemC {
    public static void main(String[] args) throws Exception {
        InputReader in = new InputReader(System.in);
        String input = in.next();

        int nb = in.nextInt();
        int ns = in.nextInt();
        int nc = in.nextInt();
        int pb = in.nextInt();
        int ps = in.nextInt();
        int pc = in.nextInt();
        long r = in.nextLong();



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
