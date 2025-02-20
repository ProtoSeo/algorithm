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
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        flatten(root.left);
        flatten(root.right);
        TreeNode lr = findRight(root.left);
        if (lr == null) {
            return;
        }
        lr.right = root.right;
        root.right = root.left;
        root.left = null;
    }

    TreeNode findRight(TreeNode node) {
        TreeNode temp = node;
        TreeNode result = null;
        while (temp != null) {
            result = temp;
            temp = temp.right;
        }
        return result;
    }
}
