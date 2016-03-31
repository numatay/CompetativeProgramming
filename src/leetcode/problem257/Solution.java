package leetcode.problem257;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nurgissa on 3/31/2016.
 *
 */
public class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ret = new ArrayList<>();
        if (root == null) { return ret; }
        binaryTreePaths(root, "", ret);
        return ret;
    }

    private void binaryTreePaths(TreeNode root, String path, List<String> paths) {
        if (root == null) return;
        if (root.left == null && root.right == null) { path += root.val; paths.add(path); return; }
        path += root.val + "->";
        binaryTreePaths(root.left, path, paths);
        binaryTreePaths(root.right, path, paths);
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}