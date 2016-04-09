package codeforces.ecr11;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * Created by Nurgissa on 4/8/2016.
 */
public class ProblemC {
    public static void main(String[] args) {
        // initialize resources
        ProblemC.InputReader in = new ProblemC.InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);

        // solution
        int n = in.nextInt();
        int k = in.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = in.nextInt();

        int l = 0, r = 0;
        int max_idx = 0;
        int max = 0;
        int kk = k;
        while (k != 0 && r < n) {
            for (; r < n; ) {
                if (r < n && a[r] == 1) r++;
                if (r < n && a[r] == 0  && kk != 0) { r++; kk--; }
                if (r < n && a[r] == 0  && kk == 0) break;
            }
            if (r-l > max) {
                max = (r-l);
                max_idx = l;
            }
            if (r >= n) break;
            //out.println("moving  right l: " + l + " r: " + r + " kk: " + kk);
            for (; l < r; ) {
                if (l < n && a[l] == 1 && kk == 0) l++;
                if (l < n && a[l] == 1 && kk != 0) break;
                if (l < n && a[l] == 0) { l++; kk++; }
            }
            //out.println("moving left l: " + l + " r: " + r + " kk: " + kk);
        }

        if (k == 0) {
            for (int i = 0; i < n; i++) {
                int c = 0;
                if (a[i] == 1) {
                    for (c = 0; i < n && a[i] == 1; i++) {c++;}
                    max = Math.max(max, c);
                }
            }
        }

        out.println(max);
        for (int i = 0; i < n; i++) {
            if (k != 0 && i >= max_idx && i < max + max_idx) { out.print(1 + " "); continue; }
            out.print(a[i] + " ");
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

