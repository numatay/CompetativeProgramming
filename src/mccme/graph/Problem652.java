package mccme.graph;

import java.io.*;
import java.util.*;

/**
 * Created by @umatayn on 9/14/2016.
 */
public class Problem652 {
    public static void main(String[] args) {
        new Thread(null, new Runnable() {
            public void run() {
                new Problem652().run();
            }
        }, "1", 1<<23).start();
    }

    private void run() {
        // initialize resources
        InputReader in = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);

        // solution
        int n = in.nextInt();
        int m = in.nextInt();

        int[][] map = new int[n][m];
        boolean[][] visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            String line = in.next();
            for (int j = 0; j < m; j++) {
                if (line.charAt(j) == '#') {
                    map[i][j] = 1;
                } else {
                    map[i][j] = 0;
                }


            }
        }

        int counter = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j] && map[i][j] == 1) {
                    dfs(map, visited, i, j);
                    counter++;
                }
            }

        }

        out.println(counter);

        // release resources
        out.close();
    }

    private static void dfs(int[][] map, boolean[][] visited, int x, int y) {
        if (x < 0 || x >= map.length) { return; }
        if (y < 0 || y >= map[0].length) { return; }
        if (visited[x][y]) return;

        if (!visited[x][y]) {
            visited[x][y] = true;
            if (map[x][y] == 1) {
                dfs(map, visited, x + 1, y);
                dfs(map, visited, x - 1, y);
                dfs(map, visited, x, y + 1);
                dfs(map, visited, x, y - 1);
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