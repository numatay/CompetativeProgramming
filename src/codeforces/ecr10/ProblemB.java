package codeforces.ecr10;

/**
 * Created by Nurgissa on 3/25/2016.
 */

import java.io.*;
import java.util.*;

public class ProblemB {
    public static void main(String[] args) {
        // initialize resources
        InputReader in = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);

        // solution
        int n = in.nextInt();
        int[] a = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }


        int l = 0, r = a.length-1;

        Arrays.sort(a);
        int c = 0;
        while (l <= r) {
            if (c % 2 == 0) {
                out.print(a[l]);
                l++;
            } else {
                out.print(a[r]);
                r--;
            }
            out.print(" ");
            c++;
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

