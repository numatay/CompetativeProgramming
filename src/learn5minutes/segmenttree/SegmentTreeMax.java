//package learn5minutes.segmenttree;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * Created by Nurgissa on 4/22/2016.
 * Problem: 752
 * URL: http://informatics.mccme.ru/mod/statements/view.php?id=597#1
 */

public class SegmentTreeMax {
    private int t[];

    public SegmentTreeMax(int n) {
        this.t = new int[2 * n];
    }

    public void add(int idx, int val) {
        idx += t.length / 2;
        t[idx] += val;
        for (; idx > 1; idx >>= 1)
            t[idx >> 1] = Math.max(t[idx], t[idx^1]);
    }

    public void dumpTree() {
        for (int val: this.t)
            System.out.print(val + " ");
        System.out.println();
    }

    public int max(int l, int r) {
        int res = Integer.MIN_VALUE;
        for (l += t.length/2, r += t.length/2; l <= r; l = (l+1) >> 1, r = (r-1) >> 1) {
            if ((l & 1) != 0)
                res = Math.max(res, t[l]);
            if ((r & 1) == 0)
                res = Math.max(res, t[r]);
        }
        return res;
    }


    public static void main(String[] args) {
        InputReader in = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int n = in.nextInt();
        SegmentTreeMax st = new SegmentTreeMax(n);
        Map<Integer, Integer> m = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int val = in.nextInt();
            st.add(i, val);
            m.put(val, i+1);
        }



        int k = in.nextInt();
        for (int i = 0; i < k; i++) {
            int l = in.nextInt();
            int r = in.nextInt();
            int mx = st.max(l-1, r-1);
            out.print(mx);
            out.println(" " + m.get(mx));
        }

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
