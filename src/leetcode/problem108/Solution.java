package leetcode.problem108;

/**
 * Created by Nurgissa on 6/3/2016.
 */

public class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBST(nums, 0, nums.length-1);
    }

    private TreeNode sortedArrayToBST(int[] nums, int l, int r) {
        // base case
        if (l > r) return null;
        // leaf nodes
        if (l == r) { return new TreeNode(nums[l]); }

        int mid = (r + l) / 2;
        TreeNode left = sortedArrayToBST(nums, l, mid-1);
        TreeNode right = sortedArrayToBST(nums, mid+1, r);
        TreeNode pnode = new TreeNode(nums[mid]);
        pnode.left = left;
        pnode.right = right;
        return pnode;
    }


    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}