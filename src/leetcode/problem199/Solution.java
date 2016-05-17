package leetcode.problem199;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nurgissa on 5/17/2016.
 */

public class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        traverse(ret, root, 1);
        return ret;
    }

    private static void traverse(List<Integer> bag, TreeNode root, int level) {
        if (root == null) return;
        if (level > bag.size()) {
            bag.add(root.val);
        }
        traverse(bag, root.right, level+1);
        traverse(bag, root.left, level+1);
    }

     static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
     }
}
