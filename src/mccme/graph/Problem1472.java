package mccme.graph;

import java.io.*;
import java.util.*;

/**
 * Created by @umatayn on 9/18/2016.
 */
public class Problem1472 {
    private static final int INF = -10;
    private int[][] a;
    private int[][] dist;
    private int[][] explored;

    public static void main(String[] args) {
        new Thread(null, new Runnable() {
            @Override
            public void run() { new Problem1472().run(); }
        }, "solution", 1<<23).start();
    }

    public void run() {
        // initialize resources
        InputReader in = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);

        // solution
        int n = in.nextInt();
        int m = in.nextInt();
        a = new int[n][m];
        dist = new int[n][m];
        explored = new int[n][m];
        List<Pair> wholes = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int val = in.nextInt();
                if (val == 2) {
                    wholes.add(new Pair(i,j));
                }
                if (val != 1) { val = 0; }
                a[i][j] = val;
                explored[i][j] = INF;
            }
        }


        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(0,0));
        dist[0][0] = 0;
        explored[0][0] = -1;

        while(!q.isEmpty()) {
            Pair uP = q.element();
            q.remove();
            int parentDirection = explored[uP.x][uP.y];
            List<Pair> vs = getEdges(uP, n, m, parentDirection);
            for (Pair vP: vs) {
                if(explored[vP.x][vP.y] == INF) {
                    int direction = getDirection(uP, vP);
                    explored[vP.x][vP.y] = direction;
                    q.add(vP);
//                    System.out.println(uP + "?" + vP);
//                    System.out.println(explored[uP.x][uP.y] + " -- "+ explored[vP.x][vP.y]);

                    if (explored[uP.x][uP.y] == explored[vP.x][vP.y]) {
                        dist[vP.x][vP.y] = dist[uP.x][uP.y];
                        } else {
                        dist[vP.x][vP.y] = dist[uP.x][uP.y] + 1;
                    }
                }
            }
        }

//        System.out.println("dist");
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < m; j++) {
//                System.out.print(dist[i][j] + "\t");
//            }
//            System.out.println();
//        }
//        System.out.println("explored");
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < m; j++) {
//                System.out.print(explored[i][j] + "\t");
//            }
//            System.out.println();
//            System.out.println();
//        }
//
//        System.out.println(wholes);
        int minDist = Integer.MAX_VALUE;
        for (Pair p: wholes) {
            if (explored[p.x][p.y] == INF) { continue; }
            minDist = Math.min(dist[p.x][p.y], minDist);
        }
        System.out.println(minDist);

        // release resources
        out.close();
    }

    public List<Pair> getEdges(Pair curr, int n, int m, int parentDirection) {
        List<Pair> ret = new ArrayList<>();
        int x = curr.x;
        int y = curr.y;

        if (parentDirection == -1) {
            if (x + 1 < n && a[x + 1][y] == 0) ret.add(new Pair(x + 1, y));
            if (x - 1 >= 0 && a[x - 1][y] == 0) ret.add(new Pair(x - 1, y));
            if (y + 1 < m && a[x][y + 1] == 0) ret.add(new Pair(x, y + 1));
            if (y - 1 >= 0 && a[x][y - 1] == 0) ret.add(new Pair(x, y - 1));
        } else {
            if (parentDirection == 12) {
                if (x + 1 < n && a[x + 1][y] == 0) {
                    ret.add(new Pair(x + 1, y));
                } else {
                    if (y + 1 < m && a[x][y + 1] == 0) ret.add(new Pair(x, y + 1));
                    if (y - 1 >= 0 && a[x][y - 1] == 0) ret.add(new Pair(x, y - 1));
                }
            } else if (parentDirection == 6) {
                if (x - 1 >= 0 && a[x - 1][y] == 0) {
                    ret.add(new Pair(x - 1, y));
                } else {
                    if (y + 1 < m && a[x][y + 1] == 0) ret.add(new Pair(x, y + 1));
                    if (y - 1 >= 0 && a[x][y - 1] == 0) ret.add(new Pair(x, y - 1));
                }
            } else  if (parentDirection == 3) {
                if (y - 1 >= 0 && a[x][y - 1] == 0) {
                    ret.add(new Pair(x, y - 1));
                } else {
                    if (x + 1 < n && a[x + 1][y] == 0) ret.add(new Pair(x + 1, y));
                    if (x - 1 >= 0 && a[x - 1][y] == 0) ret.add(new Pair(x - 1, y));
                }
            } else if (parentDirection == 9) {
                if (y + 1 < m && a[x][y + 1] == 0) {
                    ret.add(new Pair(x, y + 1));
                } else {
                    if (x + 1 < n && a[x + 1][y] == 0) ret.add(new Pair(x + 1, y));
                    if (x - 1 >= 0 && a[x - 1][y] == 0) ret.add(new Pair(x - 1, y));
                }
            }
        }
        return ret;
    }

    public int getDirection(Pair src, Pair dst) {
        int lr = src.x - dst.x;
        int td = src.y - dst.y;
        if (lr == -1) {
            return 12;
        } else if (lr == 1) {
            return 6;
        } else if (td == -1) {
            return 9;
        } else if (td == 1) {
            return 3;
        } else {
            throw new UnsupportedOperationException();
        }
    }

    static class Pair {
        public int x, y;
        public Pair() {
            throw new UnsupportedOperationException();
        }

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public String toString() {
            return String.format("%d:%d", x, y);
        }

        public boolean equals(Pair other) {
            if (other.x == x && other.y == y) {
                return true;
            } else {
                return false;
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