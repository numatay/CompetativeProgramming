package codeforces.ecr11;

/**
 * Created by Nurgissa on 4/8/2016.
 */

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


public class ProblemA {
    public static void main(String[] args) {
        // initialize resources
        InputReader in = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);

        // solution
        int n = in.nextInt();
        int[] a = new int[n];
        List<Integer> lst = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }

        int k = 0;

        lst.add(a[0]);
        for (int i = 1; i < n; i++) {
            if (gcd(a[i-1],a[i]) != 1) {
                lst.add(1);
                k++;
            }
            lst.add(a[i]);
        }

        out.println(k);
        for (Integer i: lst) {
            out.print(i + " ");
        }




        // release resources
        out.close();
    }

    public static int gcd(int a, int b) {
        while (a != b) {
            if (a > b) {
                a -= b;
            } else {
                b -= a;
            }
        }
        return a;
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
