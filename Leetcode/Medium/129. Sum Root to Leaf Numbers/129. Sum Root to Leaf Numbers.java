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
    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return sum(root, root.val);
    }

    int sum(TreeNode root, int total) {
        if (root == null || (root.left == null && root.right == null)) {
            return total;
        }
        TreeNode l = root.left;
        TreeNode r = root.right;
        int result = 0;
        if (root.left != null) {
            result += sum(l, total * 10 + l.val);
        }
        if (root.right != null) {
            result += sum(r, total * 10 + r.val);
        }
        return result;
    }
}
