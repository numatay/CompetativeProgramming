package mccme.graph;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * Created by @umatayn on 9/13/2016.
 */
public class Problem111540 {
    public static void main(String[] args) {
        new Thread(null, new Runnable() {
            @Override
            public void run() {
                new Problem111540().run();
            }
        }, "solution", 1 << 23).start();
    }

    private void run() {
        // initialize resources
        InputReader in = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);

        // solution
        int n = in.nextInt();
        List<Integer> g[] = new List[n+1];

        for (int i = 1; i <= n; i++) {
            g[i] = new ArrayList<>();
        }

        int m = in.nextInt();
        for (int i = 0; i < m; i++) {
            int u = in.nextInt();
            int v = in.nextInt();
            g[u].add(v);
            g[v].add(u);
        }

        boolean[] visited = new boolean[n+1];

        List<List<Integer>> comps = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                List<Integer> comp = new ArrayList<>();
                dfs(g, visited, i, comp);
                comps.add(comp);
            }
        }

        out.println(comps.size());
        for (List<Integer> comp: comps) {
            out.println(comp.size());
            for (Integer node: comp) {
                out.print(node + " ");
            }
            out.println();
        }

        // release resources
        out.close();
    }

    private static void dfs(List<Integer> g[], boolean[] visited, int src, List<Integer> comp) {
        visited[src] = true;
        List<Integer> vs = g[src];
        comp.add(src);
        for (Integer v: vs) {
            if (!visited[v]) {
                dfs(g, visited, v, comp);
            }
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
