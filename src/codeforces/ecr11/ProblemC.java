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

        List<Integer> seq = new ArrayList<>();
        List<Integer> idxs = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int c = 0;
            if (a[i] == 0) {
                for(c = 0; i < n && a[i] == 0; i++) {c++;}
                seq.add(c);
                idxs.add(i-c);
            }
        }

        out.print(seq);
        out.print(idxs);

        for (int i = 1; i < k; i++) {
            for (int j = 0; j < seq.size(); j++) {
                if (seq.get(j) == i)
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

