package mccme.graph;

import java.io.*;
import java.util.*;

/**
 * Created by @umatayn on 9/14/2016.
 */
public class Problem161 {

    List<Integer> g[];
    int[] dist;
    int[] p;
    boolean[] used;

    public static void main(String[] args) {
        new Thread(null, new Runnable() {
            @Override
            public void run() { new Problem161().run(); }
        }, "solution", 1<<23).start();
    }

    public void run() {
        // initialize resources
        InputReader in = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);

        // solution
        int n = in.nextInt();
        int size = n*n;

        g = new List[size+1];
        dist = new int[size+1];
        p = new int[size+1];
        used = new boolean[size+1];
        int[][] map = new int[n][n];

        int x1 = in.nextInt();
        int y1 = in.nextInt();

        int x2 = in.nextInt();
        int y2 = in.nextInt();

        for (int i = 0; i < size; i++) {
            g[i+1] = new ArrayList<>();
            map[i/n][i%n] = i+1;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i + 2 >= n || j + 1 >= n) {
                    continue;
                }
                int src = map[i][j];
                int dst = map[i + 2][j + 1];
                g[src].add(dst);
                g[dst].add(src);
            }
            for (int j = 0; j < n; j++) {
                if (i + 1 >= n || j + 2 >= n) {
                    continue;
                }
                int src = map[i][j];
                int dst = map[i + 1][j + 2];
                g[src].add(dst);
                g[dst].add(src);
            }
            for (int j = 0; j < n; j++) {
                if (i + 1 >= n || j - 2 < 0) {
                    continue;
                }
                int src = map[i][j];
                int dst = map[i + 1][j - 2];
                g[src].add(dst);
                g[dst].add(src);
            }
            for (int j = 0; j < n; j++) {
                if (i + 2 >= n || j - 1 < 0) {
                    continue;
                }
                int src = map[i][j];
                int dst = map[i + 2][j - 1];
                g[src].add(dst);
                g[dst].add(src);
            }
        }

        int src = map[x1-1][y1-1];
        int dst = map[x2-1][y2-1];

        Queue<Integer> q = new LinkedList<>();
        q.add(src);
        used[src] = true;
        dist[src] = 0;
        p[src] = -1;

        while (!q.isEmpty()) {
            int u = q.element();
            q.remove();
            List<Integer> vs = g[u];
            for (Integer v: vs) {
                if (!used[v] || (dist[v] > dist[u] + 1)) {
                    q.add(v);
                    used[v] = true;
                    dist[v] = dist[u] + 1;
                    p[v] = u;
                }
            }
        }

        System.out.println(dist[dst]);
        List<Integer> path = new LinkedList<>();
        for (int v = dst; v != -1; v = p[v]) {
            path.add(0, v);
        }
        for (Integer l: path) {
            l--;
            System.out.println((l / n + 1) + " " + (l % n + 1));
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