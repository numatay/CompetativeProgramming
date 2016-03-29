package leetcode.problem110;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Nurgissa on 3/29/2016.
 *
 * Definition for a binary tree node.
 *
 */
public class Solution {
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;

        Set<Integer> bag = new HashSet<>();
        int l = getHeight(root.left, bag);
        int r = getHeight(root.right, bag);
        return (Math.abs(r-l) <= 1 && bag.size() == 0 ? true : false);
    }

    public int getHeight(TreeNode root, Set<Integer> bag) {
        if (root == null) return 0;
        int l = 0, r = 0;
        l = getHeight(root.left, bag) + 1;
        r = getHeight(root.right, bag) + 1;
        if (Math.abs(l-r) > 1) bag.add(1);
        return Math.max(l,r);
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }


}
