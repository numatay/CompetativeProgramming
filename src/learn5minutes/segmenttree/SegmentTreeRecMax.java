package learn5minutes.segmenttree;

import java.io.*;
import java.util.Objects;
import java.util.StringTokenizer;

/**
 * Created by macnur on 4/23/16.
 */
public class SegmentTreeRecMax {
    private Pair[] tree;

    public static void main(String[] args) {
        InputReader in = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int n = in.nextInt();
        int[] a = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }


        SegmentTreeRecMax st = new SegmentTreeRecMax(n);
        st.build(a, 1, 0, n-1);
//        st.printTree();

        int k = in.nextInt();
        int l, r;
        Pair ret = null;
        for (int i = 0; i < k; i++) {
            l = in.nextInt();
            r = in.nextInt();
            ret = st.getVal(l-1,r-1,1,0,n-1);
            out.print((ret.getSecond()+1) + " ");
        }

        out.close();
    }

    public SegmentTreeRecMax(int n) {
        this.tree = new Pair[4 * n];
    }

    public void build(int[] in, int v, int tl, int tr) {
        // base case
        if (tl == tr) {
            this.tree[v] = new Pair(in[tl], tl);
        } else {

            int tm = (tr - tl) / 2 + tl;
            build(in, 2 * v, tl, tm);
            build(in, 2 * v + 1, tm + 1, tr);
            tree[v] = (tree[2 * v].getFirst() > tree[2 * v + 1].getFirst() ?
                    tree[2 * v] : tree[2 * v + 1]);
        }
    }

    public void printTree() {
        for (Pair p: tree) {
            System.out.print(p + " ");
        }
        System.out.println();
    }

    public Pair getVal(int l, int r, int v, int tl, int tr) {
        // case I
        if (l <= tl && tr <= r) {
            return tree[v];
        }

        // case II

        if (tr < l || r < tl) {
            return new Pair(Integer.MIN_VALUE, Integer.MIN_VALUE);
        }

        // case III
        int tm = (tr-tl)/2 + tl;
        Pair left = getVal(l, r, 2*v, tl, tm);
        Pair right = getVal(l, r, 2*v+1, tm+1, tr);

        return (left.getFirst() > right.getFirst() ? left : right);
    }


    static class Pair {
        private int a, b;

        public Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }

        public int getFirst() {
            return a;
        }

        public int getSecond() {
            return b;
        }

        public boolean equals(Object pr) {
            if (!(pr instanceof Pair)) return false;
            if (a == ((Pair) pr).getFirst()) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return Objects.hash(a,b);
        }

        public String toString() {
            return this.a + " " + this.b;
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
