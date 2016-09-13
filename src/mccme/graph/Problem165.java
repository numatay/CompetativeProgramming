package mccme.graph;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * Created by @umatayn on 9/13/2016.
 */
public class Problem165 {
    public static void main(String[] args) {
        // initialize resources
        InputReader in = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);

        // solution
        int n = in.nextInt();
        List<Integer> g[] = new List[n+1];
        int[] colors = new int[n+1];

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

        for (int i = 1; i <= n; i++) {
            if (!visited[i])
                dfs(g, colors, 0, visited, i);
        }

        for (int u = 1; u <= n; u++) {
            List<Integer> vs = g[u];
            for (Integer v: vs) {
                if (colors[u] == colors[v]) {
                    System.out.println("NO");
                    return;
                }
            }
        }



        System.out.println("YES");
        for (int i = 1; i <= n; i++) {
            if (colors[i] == 0) {
                System.out.print(i + " ");
            }
        }

        // release resources
        out.close();
    }

    private static void dfs(List<Integer> g[], int colors[], int color, boolean[] visited, int src) {
        visited[src] = true;
        colors[src] = color % 2;
        List<Integer> vs = g[src];
        color++;
        for (Integer v: vs) {
            if (!visited[v]) {
                dfs(g, colors, color, visited, v);
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