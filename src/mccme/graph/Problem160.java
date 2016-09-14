package mccme.graph;

import java.io.*;
import java.util.*;

/**
 * Created by @umatayn on 9/14/2016.
 */
public class Problem160 {

    int[][] g;
    int[] dist;
    int[] p;
    boolean[] used;

    public static void main(String[] args) {
        new Thread(null, new Runnable() {
            @Override
            public void run() { new Problem160().run(); }
        }, "solution", 1<<23).start();
    }

    public void run() {
        // initialize resources
        InputReader in = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);

        // solution
        int n = in.nextInt();

        g = new int[n+1][n+1];
        dist = new int[n+1];
        p = new int[n+1];
        used = new boolean[n+1];

        for (int i = 1; i <= n; i++) {
            dist[i] = -1;
            for (int j = 1; j <= n; j++) {
                g[i][j] = in.nextInt();

            }
        }



        int src = in.nextInt();
        int dst = in.nextInt();

        p[src] = -1;
        dist[src] = 0;
        used[src] = true;

        Queue<Integer> q = new LinkedList<>();
        q.add(src);

        while (!q.isEmpty()) {
            int u = q.element();
            q.remove();

            for (int v = 1; v <= n; v++) {
                if (g[u][v] == 1) {
                    if (!used[v]) {
                        q.add(v);
                        used[v] = true;
                        dist[v] = dist[u] + 1;
                        p[v] = u;
                    }
                }
            }
        }

        out.println(dist[dst]);

        if (dist[dst] != -1) {
            List<Integer> parents = new LinkedList<>();
            for (int node = dst; node != -1; ) {
                parents.add(0, node);
                node = p[node];
            }
            if (parents.size() > 1) {
                for (Integer v : parents) {
                    out.print(v + " ");
                }
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