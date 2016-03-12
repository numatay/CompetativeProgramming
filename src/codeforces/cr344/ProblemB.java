package codeforces.cr344;

import java.util.*;

/**
 * Created by ABiryulin on 3/9/2016.
 */
public class ProblemB {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int k = in.nextInt();
        int[] cols = new int[m+1];
        int[] rows = new int[n+1];
        Pair[] h = new Pair[n+m+1];
        int[][] a = new int[m][n];

        int last = -1;
        boolean circled = false;
        for (int i = 0; i < k; i++) {
            if (i > (n+m))
                circled = true;
            int type = in.nextInt();
            int y = in.nextInt();
            int c = in.nextInt();
            if (type == 1) {
                rows[y-1] = c;
            } else {
                cols[y-1] = c;
            }
            Pair p = new Pair(type, y, c);
            h[i % (n+m)] = p;
            last = i % (n+m);
        }

        for (int i = 0; i < n+m; i++) {
            //System.out.println(h[(i % (n*m))-1]);
            if (circled) {
                last++;
            } else {
                last = 0;
            }
            Pair p = h[last%(n+m)];
            int type = p.getFirst();
            int w = p.getSecond();
            int color = p.getThird();
            if (type == 1) {
                updateRows(a, w, color);
            } else {
                updateCols(a, w, color);
            }

            for (int ii = 0; ii < a.length; ii++) {
                for (int jj = 0; jj < a[0].length; jj++) {
                    System.out.print(a[ii][jj] + ' ');
                }
                System.out.println();
            }
        }


    }
    public static void updateRows(int[][] a, int w, int c) {
        for (int i = 0; i < a.length; i++) {
            a[w][i] = c;
        }
    }

    public static void updateCols(int[][] a, int w, int c) {
        for (int i = 0; i < a[w].length; i++) {
            a[i][w] = c;
        }
    }



}
class Pair {
    private int a;
    private int b;
    private int c;
    public Pair(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    public int getFirst() {
        return this.a;
    }
    public int getSecond() {
        return this.b;
    }
    public int getThird() {
        return this.c;
    }
}
