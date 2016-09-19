package mccme.graph;

import java.io.*;
import java.util.*;

/**
 * Created by @umatayn on 9/18/2016.
 */
public class Problem2001 {
    int[] d;
    int[] p;

    public static void main(String[] args) {
        new Thread(null, new Runnable() {
            @Override
            public void run() { new Problem2001().run(); }
        }, "solution", 1<<23).start();
    }

    public void run() {
        // initialize resources
        InputReader in = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);

        // solution
        int src = in.nextInt();
        int dst = in.nextInt();

        d = new int[10000];
        p = new int[10000];

        Arrays.fill(d, -1);

        Queue<Integer> q = new LinkedList<>();

        q.add(src);
        d[src] = 0;
        p[src] = -1;

        while (!q.isEmpty()) {
            int u = q.element();
            q.remove();
            List<Integer> vs = getEdges(u);
            for (Integer v: vs) {
                if (d[v] == -1) {
                    q.add(v);
                    d[v] = d[u] + 1;
                    p[v] = u;
                }
            }
        }

        List<Integer> seq = new LinkedList<>();

        for (int s = dst; s != -1; s = p[s]) {
            seq.add(0, s);
        }
        for (Integer s: seq) {
            System.out.println(s);
        }

        // release resources
        out.close();
    }

    private int rule1(int num) {
        int msd = num / 1000;
        if (msd != 0 && msd < 9) {
            return num + 1000;
        }
        return num;
    }

    private int rule2(int num) {
        int lsn = num % 10;
        if (lsn != 0 && lsn > 1) {
            return --num;
        }
        return num;
    }

    private int rule3(int num) {
        int shifted = num / 10;
        shifted = shifted + (num % 10) * 1000;
        return shifted;
    }

    private int rule4(int num) {
        int shifted = num % 1000;
        shifted = shifted * 10 + (num / 1000);
        return shifted;
    }

    private List<Integer> getEdges(int u) {
        List<Integer> edges = new ArrayList<>();
        edges.add(rule1(u));
        edges.add(rule2(u));
        edges.add(rule3(u));
        edges.add(rule4(u));
        return edges;
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