package mccme.graph;

import java.io.*;
import java.util.*;

/**
 * Created by @umatayn on 9/22/2016.
 */
public class Problem182 {
    private List[] g;
    private int[] d;

    public static void main(String[] args) {
        new Thread(null, new Runnable() {
            @Override
            public void run() { new Problem182().run(); }
        }, "solution", 1<<23).start();
    }

    public void run() {
        // initialize resources
        InputReader in = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);

        // solution
        int n = in.nextInt();
        int m = in.nextInt();

        g = new List[n+1];
        d = new int[n+1];

        Arrays.fill(d, -1);
        for (int i = 1; i <= n; i++) {
            g[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            int u = in.nextInt();
            int v = in.nextInt();
            g[u].add(v);
            g[v].add(u);
        }

        int src = 1;
        d[src] = 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(src);

        while (!q.isEmpty()) {
            int u = q.element();
            q.remove();

            List<Integer> vs = g[u];
            Iterator<Integer> it = vs.iterator();
            while (it.hasNext()) {
                int v = it.next();
                if (d[v] == -1) {
                    q.add(v);
                    d[v] = d[u] + 1;
                } else {
                    it.remove();
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            List<Integer> vs =  g[i];
            for (Integer v: vs) {
                System.out.println(i + " " + v);
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