package leetcode.problem111;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nurgissa on 3/28/2016.
 *
 * Problem statement: Given a binary tree, find its minimum depth. The minimum depth is the number of nodes
 * along the shortest path from the root node down to the nearest leaf node.
 */
public class Solution {
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        int lvl = 1, depth = Integer.MAX_VALUE;
        List<Integer> lst = new ArrayList<>();
        minDepth(root, lvl, lst);
        for (Integer i: lst)
            depth = Math.min(depth, i);
        return depth;
    }

    private void minDepth(TreeNode root, int lvl, List<Integer> lst) {
        if (root == null) { return; }
        if (root.left == null && root.right == null) {
            lst.add(lvl);
        }
        minDepth(root.left, lvl+1, lst);
        minDepth(root.right, lvl+1, lst);
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}