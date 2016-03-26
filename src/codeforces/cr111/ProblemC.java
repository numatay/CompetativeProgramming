package codeforces.cr111;

import java.io.*;
import java.util.*;

/**
 * Created by macnur on 3/27/16.
 */
public class ProblemC {
    public static void main(String[] args) {
        // initialize resources
        InputReader in = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);

        // solution
        int n = in.nextInt();
        long l = in.nextLong();
        l--;

        List<Pair> lst = new ArrayList<>();


        int[] a = new int[n];


        for (int i = 0; i < n; i++)
            a[i] = in.nextInt();

        if (l < 10000) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    lst.add(new Pair(a[i], a[j]));
                }
            }

            Collections.sort(lst);

            out.print(lst.get((int)l));
        } else {

            Arrays.sort(a);

            int r = (int) l / n;
            int c = (int) l % n;


            for (int j = 0; j < n; j++) {
                lst.add(new Pair(a[r], a[j]));
            }

            Collections.sort(lst);

            out.print(lst.get(c));
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

    static class Pair implements Comparable<Pair> {
        private int a;
        private int b;

        public Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }

        public int getA() { return this.a; }
        public int getB() { return this.b; }

        @Override
        public int compareTo(Pair o) {
            if (this.a == o.getA()) {
                if (this.b == o.getB()) return 0;
                else if (this.b < o.getB()) return -1;
                else return 1;
            } else if (this.a < o.getA()) {
                return -1;
            } else {
                return 1;
            }
        }

        public String toString() {
            return this.a + " " + this.b;
        }
    }

}
