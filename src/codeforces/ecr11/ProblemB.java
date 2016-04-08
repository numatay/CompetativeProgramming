package codeforces.ecr11;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * Created by Nurgissa on 4/8/2016.
 */
public class ProblemB {
    public static void main(String[] args) {
        // initialize resources
        ProblemB.InputReader in = new ProblemB.InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);


        // solution
        int n = in.nextInt();
        int m = in.nextInt();

        List<Integer> lw = new LinkedList<>();
        List<Integer> rw = new LinkedList<>();
        List<Integer> li = new LinkedList<>();
        List<Integer> ri = new LinkedList<>();
        List<Integer> all = new ArrayList<>();

        int i = 1;
        while (i <= m) {
            if (i <= 2*n) {
                lw.add(i);
                i++;
            }
            if (i <= 2*n) {
                rw.add(i);
                i++;
            }
            if (i > 2*n && i <=m) {
                li.add(i);
                i++;
            }
            if (i > 2*n && i <=m) {
                ri.add(i);
                i++;
            }
        }


        i = 1;
        while (i <= m) {
            if (i <= m) {
                if (!li.isEmpty()) {
                    all.add(li.remove(0));
                    i++;
                }
            }
            if (i <= m) {
                if (!lw.isEmpty()) {
                    all.add(lw.remove(0));
                    i++;
                }
            }
            if (i <= m) {
                if (!ri.isEmpty()) {
                    all.add(ri.remove(0));
                    i++;
                }
            }
            if (i <= m) {
                if (!rw.isEmpty()) {
                    all.add(rw.remove(0));
                    i++;
                }
            }
        }

        for (int j = 0; j < m; j++)
            out.print(all.get(j) + " ");






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
