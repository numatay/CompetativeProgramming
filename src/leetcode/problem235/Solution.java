package leetcode.problem235;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by @umatayn on 9/2/2016.
 */
public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> pParents = new LinkedList<>();
        List<TreeNode> qParents = new LinkedList<>();
        search(root, p, pParents);
        search(root, q, qParents);

        int l = 0, r = 0;
        TreeNode lca = null;
        while (pParents.get(l) == qParents.get(r)) {
            lca = pParents.get(l);
            l++;
            r++;
            if ((pParents.size() == l) || (qParents.size() == r)) {
                break;
            }
        }

        return lca;
    }

    private static TreeNode search(TreeNode current, TreeNode target, List<TreeNode> parents) {
        if (current == null) {
            return null;
        }

        parents.add(current);

        if (current.val == target.val) {
            return current;
        } else if (current.val < target.val) {
            return search(current.right, target, parents);
        } else {
            return search(current.left, target, parents);
        }
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
