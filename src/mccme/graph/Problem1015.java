package mccme.graph;

import java.io.*;
import java.util.*;

/**
 * Created by @umatayn on 9/19/2016.
 */
public class Problem1015 {
    int[][] a;
    int[][] d;
    final int INF = 10001;


    public static void main(String[] args) {
        new Thread(null, new Runnable() {
            @Override
            public void run() {
                new Problem1015().run();
            }
        }, "solution", 1 << 23).start();
    }

    public void run() {
        // initialize resources
//        InputReader in = new InputReader(System.in);
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        // solution
        int n = in.nextInt();
        int m = in.nextInt();

        a = new int[n+2][m+2];
        d = new int[n+2][m+2];


        for (int i = 0; i < n+2; i++) {
            for (int j = 0; j < m+2; j++) {
                if (i == 0 || i == n+1 || j == 0 || j == m+1) {
                    a[i][j] = INF;
                } else {
                    a[i][j] = in.nextInt();
                }
            }
        }



        int cnt = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (d[i][j] == 0) {
                    cnt += bfs(i,j);
                }
            }
        }
        System.out.println(cnt);

    // release resources
        out.close();
    }

    private int bfs(int x, int y) {
        Queue<Integer> q = new LinkedList<>();
        q.add(x);
        q.add(y);
        d[x][y] = 1;

        int sink = 1;

        while (!q.isEmpty()) {
            int i = q.element();
            q.remove();
            int j = q.element();
            q.remove();

            if ((a[i-1][j] < a[i][j]) ||
                (a[i][j-1] < a[i][j]) ||
                (a[i+1][j] < a[i][j]) ||
                (a[i][j+1] < a[i][j])) {
                sink = 0;
            }

            if (a[i-1][j] == a[i][j] && d[i-1][j] == 0) {
                q.add(i-1);
                q.add(j);
                d[i-1][j] = 1;
            }
            if (a[i+1][j] == a[i][j] && d[i+1][j] == 0) {
                q.add(i+1);
                q.add(j);
                d[i+1][j] = 1;
            }
            if (a[i][j-1] == a[i][j] && d[i][j-1] == 0) {
                q.add(i);
                q.add(j-1);
                d[i][j-1] = 1;
            }
            if (a[i][j+1] == a[i][j] && d[i][j+1] == 0) {
                q.add(i);
                q.add(j+1);
                d[i][j+1] = 1;
            }
        }

        return sink;

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