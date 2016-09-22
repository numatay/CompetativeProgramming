package mccme.graph;

import java.io.*;
import java.util.*;

/**
 * Created by @umatayn on 9/14/2016.
 */
public class Problem1748 {
    private final int N = 2000;
    private int[] d;

    public static void main(String[] args) {
        new Thread(null, new Runnable() {
            @Override
            public void run() { new Problem1748().run(); }
        }, "solution", 1<<23).start();
    }

    public void run() {
        // initialize resources
        InputReader in = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int a = in.nextInt();
        int b = in.nextInt();

        d = new int[N];
        Arrays.fill(d, -1);

        Queue<Integer> q = new LinkedList<>();
        d[a] = 0;

        q.add(a);

        while(!q.isEmpty()) {
            int u = q.element();
            q.remove();

            for (Integer v: getEdges(u)) {
                if (v <= b && d[v] == -1) {
                    d[v] = d[u] + 1;
                    q.add(v);
                }
            }
        }


        // solution
        System.out.println(d[b]);

        // release resources
        out.close();
    }

    private List<Integer> getEdges(int u) {
        List<Integer> ret = new ArrayList<>();
        ret.add(rule1(u));
        ret.add(rule2(u));
        return ret;
    }

    private int rule1(int u) {
        return u + 3;
    }

    private int rule2(int u) {
        return u * 4;
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