/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        if (root == null) {
            return null;
        }
        return dfs(root).key;
    }

    private Pair dfs(TreeNode root) {
        if (root == null) {
            return new Pair(null, 0);
        }
        Pair left = dfs(root.left);
        Pair right = dfs(root.right);

        if (left.value > right.value) {
            return new Pair(left.key, left.value + 1);
        } else if (left.value < right.value) {
            return new Pair(right.key, right.value + 1);
        }
        return new Pair(root, left.value + 1);
    }
}

class Pair {
    TreeNode key;
    int value;

    public Pair(TreeNode key, int value) {
        this.key = key;
        this.value = value;
    }
}
