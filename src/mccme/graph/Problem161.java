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

        int x1 = in.nextInt();
        int y1 = in.nextInt();

        int x2 = in.nextInt();
        int y2 = in.nextInt();

        for (int i = 1; i <= size; i++) {
            g[i] = new ArrayList<>();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= n; j++) {
                int src = i*n + j;
                int dst = (i+1) * n + (j+2);
                if (dst > 0 && dst <= n*n) {
                    g[src].add(dst);
                    g[dst].add(src);
                }
            }
            for (int j = 1; j <= n; j++) {
                int src = i*n + j;
                int dst = (i+2) * n + (j+1);
                if (dst > 0 && dst <= n*n) {
                    g[src].add(dst);
                    g[dst].add(src);
                }
            }
            for (int j = 1; j <= n; j++) {
                int src = i*n + j;
                int dst = (i+1) * n + (j-2);
                if (dst > 0 && dst <= n*n) {
                    g[src].add(dst);
                    g[dst].add(src);
                }
            }
            for (int j = 1; j <= n; j++) {
                int src = i*n + j;
                int dst = (i+2) * n + (j-1);
                if (dst > 0 && dst <= n*n) {
                    g[src].add(dst);
                    g[dst].add(src);
                }
            }
        }

        int src = (x1-1)*n + y1;
        int dst = (x2-1)*n + y2;

        Queue<Integer> q = new LinkedList<>();
        q.add(src);
        p[src] = -1;
        used[src] = true;
        dist[src] = 0;

        while(!q.isEmpty()) {
            int u = q.element();
            System.out.println("popped from stack " + u);
            q.remove();
            List<Integer> vs = g[u];
            for (Integer v: vs) {
                if (!used[v]) {
                    q.add(v);
                    used[v] = true;
                    dist[v] = dist[u] + 1;
                    p[v] = u;
                }
            }
        }

        System.out.println(src);
        System.out.println(dst);
        System.out.println(dist[dst]);

        for (int i = 1; i < dist.length; i++) {
            System.out.println(i + "=" + dist[i]);
            System.out.println(g[i]);
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