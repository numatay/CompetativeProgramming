package leetcode.problem129;

/**
 * Created by Nurgissa on 5/24/2016.
 */

public class Solution {
    public int sumNumbers(TreeNode root) {
        return sum(root, 0);
    }
    private int sum(TreeNode pnode, int s) {
        if (pnode == null) { return 0; }
        s = (s * 10) + pnode.val;
        if (pnode.left == null && pnode.right == null) return s;
        return sum(pnode.left, s) + sum(pnode.right, s);
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
