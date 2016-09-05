package mccme.graph;

import java.io.*;
import java.util.*;

/**
 * Created by @umatayn on 9/2/2016.
 */
public class Problem111539 {
    public static void main(String[] args) {
        // initialize resources
        InputReader in = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);

        // solution
        int n = Integer.parseInt(in.nextLine());
        int[][] a = new int[n+1][n+1];
        boolean[] marked = new boolean[n+1];
        for (int i = 1; i <= n; i++) {
            String line = in.nextLine();
            if (line.isEmpty()) { continue; }
            String[] vals = line.split("\\s");

            for (int j = 0; j < vals.length; j++) {
                int v = Integer.parseInt(vals[j]);
                a[i][v]++;
                marked[v] = true;
            }
        }

        System.out.println(n);

        for (int i = 1; i <= n; i++) {
            if (marked[i]) {
                for (int rows = 1; rows <= n; rows++) {
                    System.out.print((a[rows][i] == 0 ? "" : rows + " "));
                }
                System.out.println();
            } else {
                System.out.println();
            }
        }
//        HashMap<Integer, ArrayList<Integer>> g = new HashMap<Integer, ArrayList<Integer>>();
//        for (int i = 0; i < n; i++) {
//            String[] vals = in.nextLine().split(" ");
//            for (int j = 0; j < vals.length; j++) {
//                if (!vals[j].isEmpty()) {
//                    int v = Integer.parseInt(vals[j]);
//                    if (!g.containsKey(v)) {
//                        g.put(v, new ArrayList<Integer>());
//                    }
//                    List<Integer> vs = g.get(v);
//                    vs.add(i);
//                }
//            }
//        }
//
//        System.out.println(n);
//        for (int i = 1; i < n; i++) {
//            if (!g.containsKey(i)) {
//                System.out.println();
//            } else {
//                List<Integer> vs = g.get(i);
//                for (Integer v: vs) {
//                    System.out.print((v+1) + " ");
//                }
//                System.out.println();
//            }
//        }






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

        public String nextLine() {
            try {
                return reader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }
    }
}