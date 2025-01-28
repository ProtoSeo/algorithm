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
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return countDepth(root, 1);
    }

    private int countDepth(TreeNode node, int depth) {
        int left = 0, right = 0;
        if (node.left != null) {
            left = countDepth(node.left, depth + 1);
        }
        if (node.right != null) {
            right = countDepth(node.right, depth + 1);
        }
        return Math.max(depth, Math.max(left, right));
    }
}
