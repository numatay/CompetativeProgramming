package mccme.graph;

import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by @umatayn on 9/2/2016.
 */
public class Problem474 {
    public static void main(String[] args) {
        // initialize resources
        InputReader in = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);

        // solution
        int n = in.nextInt();
        int[] inner = new int[n+1];
        int[] outer = new int[n+1];


        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                int val = in.nextInt();
                if (val == 1) {
                    outer[i]++;
                    inner[j]++;
                }
            }
        }

        int cOut = 0;
        for (int i = 1; i <= n; i++) {
            if (inner[i] == 0) { cOut++; }
        }

        System.out.println(cOut);
        for (int i = 1; i <= n; i++) {
            if (inner[i] == 0) {
                System.out.println(i);
            }
        }

        int cIn = 0;
        for (int i = 1; i <= n; i++) {
            if (outer[i] == 0) { cIn++; }
        }

        System.out.println(cIn);
        for (int i = 1; i <= n; i++) {
            if (outer[i] == 0) {
                System.out.println(i);
            }
        }

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