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
        Map<Integer, Integer> hm = new HashMap<>();
        Set<Integer> ts = new TreeSet<>();

        int x;
        int v;
        for (int i = 0; i < n; i++) {
            x = in.nextInt();
            ts.add(x);
            if (!hm.containsKey(x)) {
                hm.put(x, 1);
            } else {
                v = hm.get(x);
                hm.put(x, v+1);
            }
        }


        List<Integer> keys = new ArrayList();
        int qq;
        for (Integer q: ts) {
            qq = hm.get(q);
            for (int i = qq; i > 0; i--)
                keys.add(q);
        }

        int l = 0, r = keys.size()-1;

        boolean hasKeys = true;

        //out.println(hm);

        int c = 0;

        while (l <= r) {
            if (c % 2 == 0) {
                System.out.print(keys.get(l));
                l++;
            } else {
                System.out.print(keys.get(r));
                r--;
            }
            System.out.print(" ");
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

