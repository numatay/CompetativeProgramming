package mccme.graph;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * Created by @umatayn on 9/2/2016.
 */
public class Problem111541 {
    public static void main(String[] args) {
        // initialize resources
        InputReader in = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);

        // solution
        int n = in.nextInt();
        int[][] a = new int[n+1][n+1];


        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                a[i][j] = in.nextInt();
            }
        }

        int[] visited = new int[n+1];


        Stack<Integer> st = new Stack<>();
        st.push(1);
        int nodes = n;

        while (!st.empty()) {
            int u = st.pop();
            if (visited[u] == 0) {
                visited[u] = 1;
                nodes--;
            } else if (visited[u] == 1) {
                System.out.println("NO");
                return;
            }

            for (int i = 1; i <= n; i++) {
                if (a[u][i] == 1 && u != i && visited[i] == 0) {
                    st.push(i);
                }
            }
        }

        String res = (nodes == 0 ? "YES" : "NO");
        System.out.println(res);


        // release resources
        out.close();
    }

    private static int dfs(int[][] g, boolean[] visited, int u) {
        if (!visited[u]) {
            visited[u] = true;
            for (int v = 1; v <= g.length; v++) {
                if (g[u][v] == 1) {
                    return 1 + dfs(g, visited, v);
                }
            }
        }
        return 0;
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