package leetcode.problem236;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by @umatayn on 9/2/2016.
 */
public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Map<TreeNode, TreeNode> nodes = new HashMap<TreeNode, TreeNode>();
        Set<TreeNode> parents = new HashSet<TreeNode>();

        walkDown(root, root, nodes);

        walkUp(p, parents, nodes);
        return walkUp(q, parents, nodes);
    }

    private static void walkDown(TreeNode cur, TreeNode parent, Map<TreeNode, TreeNode> nodes) {
        if (cur == null) {
            return;
        } else if (nodes.containsKey(cur)) {
            return;
        }

        nodes.put(cur, parent);
        walkDown(cur.left, cur, nodes);
        walkDown(cur.right, cur, nodes);
    }

    private static TreeNode walkUp(TreeNode cur, Set<TreeNode> parents, Map<TreeNode, TreeNode> nodes) {
        TreeNode parent = cur;
        while (parent != null) {
            if (parents.contains(parent)) {
                return parent;
            }
            parents.add(parent);
            parent = nodes.get(parent);
        }
        return null;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
