package learn5minutes.segmenttree;

import learn5minutes.segmenttree.*;

/**
 * Created by mcnr on 4/23/16.
 */
public class SegmentTreeRecSum {
    private int[] tree;
    public static void main(String[] args) {
        int a[] = new int[] {3,2,5,11,2};
        SegmentTreeRecSum st = new SegmentTreeRecSum(a.length);
        st.build(a, 1, 0, a.length-1);
        st.printTree();

        st.updateVal(3, 100, 1, 0, a.length-1);
        st.printTree();
        System.out.println(st.getVal(3, 4, 1, 0, a.length-1));


       /* SegmentTreeMax stm = new SegmentTreeMax(a.length);
        for (int i = 0; i < a.length; i++) {
            stm.add(i, a[i]);
        }
        stm.dumpTree();*/
    }



    // constructor
    public SegmentTreeRecSum(int n) {
        this.tree = new int[4 * n];
    }

    // interface of the segment tree data structure
    public void build(int[] in, int v, int tl, int tr) {
        /*
        System.out.println("v-" + v);
        System.out.println("tl-" + tl);
        System.out.println("tr-" + tr);
        */
        if (tl >= tr) {
            tree[v] = in[tl];
        } else {
            int mid = (tr-tl)/2 + tl;
            build(in, v*2, tl, mid);
            build(in, v*2+1, mid+1, tr);
            tree[v] = tree[v*2] + tree[2*v+1];
//          System.out.println("summing up: " + v + "lt: " + (v*2) + " rt: " + (v*2+1));
        }

    }

    public int getVal(int l, int r, int v, int tl, int tr) {

        // case 1
        if (l <= tl && tr <= r) {
//            System.out.println("case 1 " + tree[v] );
            return tree[v];
        }

        // case 2
        if (tr < l || r < tl) {
//            System.out.println("case 2 " + v );
            return 0;
        }

        // case 3
        int mid = (tr - tl) / 2 + tl;
//        System.out.println("case 3 " + v);
        return getVal(l, r, v*2, tl, mid) + getVal(l, r, v*2 + 1, mid+1, tr);

    }

    public void updateVal(int idx, int val, int v, int tl, int tr) {
        if (idx == tl && tr == idx) {
            tree[v] = val;
            return;
        }

        if (idx < tl || tr < idx) {
            return;
        }

        int mid = (tr-tl)/2 + tl;
        updateVal(idx, val, v*2, tl, mid);
        updateVal(idx, val, v*2+1, mid+1, tr);
        tree[v] = tree[2*v] + tree[2*v+1];
    }

    public void printTree() {
        for (int i = 0; i < tree.length; i++)
            System.out.print("[" + i + "|" + tree[i] + "] ");
        System.out.println();
    }

}
