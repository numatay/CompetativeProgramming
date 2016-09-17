package mccme.graph;

import java.io.*;
import java.util.*;

/**
 * Created by @umatayn on 9/14/2016.
 */
public class Problem162 {
    int[] dist;

    public static void main(String[] args) {
        new Thread(null, new Runnable() {
            @Override
            public void run() { new Problem162().run(); }
        }, "solution", 1<<23).start();
    }

    public void run() {
        // initialize resources
        InputReader in = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);

        // solution
        int n = in.nextInt();
        int m = in.nextInt();
        int[][] a = new int[n][m];
        dist = new int[n*m+1];

        List<Pair> start = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int val = in.nextInt();
                a[i][j] = val;
                if (val == 1) {
                    start.add(new Pair(i, j));
                }
            }
        }

        boolean[] used = new boolean[n*m];
        Queue<Pair> q = new LinkedList<>();
        for (int i = 0; i < n*m; i++) {
            dist[i] = Integer.MAX_VALUE;
        }


        for (Pair p: start) {
            q.clear();
            q.add(p);
            int pos = p.x * m + p.y;
            used[pos] = true;
            dist[pos] = 0;
            while (!q.isEmpty()) {
                Pair u = q.element();
                q.remove();
                int uPos = u.x * m + u.y;
                List<Pair> vs = getEdges(u.x, u.y, n, m);
                for (Pair v : vs) {
                    int vPos = v.x * m + v.y;
                    if (!used[vPos] && (dist[uPos]+1 < dist[vPos])) {
                        q.add(v);
                        used[vPos] = true;
                        dist[vPos] = dist[uPos] + 1;
                    }
                }
            }
            used = new boolean[n * m];
        }

        for (int i = 0; i < n*m; i++) {
            if (i % m == 0) {
                System.out.println();
            }
            System.out.print(dist[i] + " ");

        }


        // release resources
        out.close();
    }

    public List<Pair> getEdges(int x, int y, int n, int m) {
        List<Pair> ret = new ArrayList<>();
        if (x+1 < n) ret.add(new Pair(x+1, y));
        if (x-1 >= 0) ret.add(new Pair(x-1, y));
        if (y+1 < m) ret.add(new Pair(x, y+1));
        if (y-1 >= 0) ret.add(new Pair(x, y-1));
        return ret;
    }

    public int dist(int x1, int y1, int x2, int y2) {
        return Math.abs(x1-x2) + Math.abs(y1-y2);
    }

    static class Pair {
        public int x, y;
        public Pair() {
            throw new UnsupportedOperationException();
        }

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public String toString() {
            return String.format("%d:%d", x, y);
        }
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