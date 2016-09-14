package mccme.graph;

import java.io.*;
import java.util.*;

/**
 * Created by @umatayn on 9/14/2016.
 */
public class Problem166 {
    static List<Integer> order = new ArrayList<>();

    public static void main(String[] args) {
        new Thread(null, new Runnable() {
            @Override
            public void run() { new Problem166().run(); }
        }, "solution", 1<<23).start();
    }

    public void run() {
        // initialize resources
        InputReader in = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);

        // solution
        int n = in.nextInt();
        int m = in.nextInt();

        List<Integer> g[] = new List[n+1];

        for (int i = 1; i <= n; i++) {
            g[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            int u = in.nextInt();
            int v = in.nextInt();
            g[u].add(v);
        }

        int color[] = new int[n+1];

        boolean hasCycles = false;
        for (int i = 1; i <= n; i++) {
            if (color[i] == 0) {
                hasCycles |= dfs(g, color, i);
            }
        }

        out.println(hasCycles ? "No" : "Yes");
        if (!hasCycles) {
            for (int i = order.size()-1; i >= 0; i--) {
                out.print(order.get(i) + " ");
            }
        }

        // release resources
        out.close();
    }

    private static boolean dfs(List<Integer> g[], int color[], int src) {
        boolean result = false;
        color[src] = 1;
        List<Integer> vs = g[src];
        for (Integer v: vs) {
            if (color[v] == 0) {
                result |= dfs(g, color, v);
            } else if (color[v] == 1) {
                return true;
            }
        }
        color[src] = 2;
        order.add(src);
        return result;
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