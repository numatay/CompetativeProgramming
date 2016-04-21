package codeforces.april2016;

import java.io.*;
import java.util.*;

public class ProblemB {
    public static void main(String[] args) {
        // initialize resources
        InputReader in = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);

        // solution
        int n = in.nextInt();

        int[] m = new int[n];
        int[] r = new int[n];

        for (int i = 0; i < n; i++)
            m[i] = in.nextInt();

        for (int i = 0; i < n; i++)
            r[i] = in.nextInt();

        int me = 1, room = 0;
        for (int j = 0; j < n; j++) {
            for (int i = 1; i < 16; i++) {
                if (i % m[j] == r[j]) {
                    me++;
                } else {
                    room++;
                }
            }
            if (me == room) {
                room = 0;
                me = 0;
            }
        }
        out.println((me * 1.0) / room);

        //out.println(res2-res1);

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
