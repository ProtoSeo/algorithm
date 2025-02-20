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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length == 0 || postorder.length == 0) {
            return null;
        }
        int value = postorder[postorder.length - 1];
        int idx = indexOf(inorder, value);
        return new TreeNode(value,
                buildTree(copy(inorder, 0, idx), copy(postorder, 0, idx)),
                buildTree(copy(inorder, idx + 1, inorder.length), copy(postorder, idx, postorder.length - 1))
        );
    }

    int indexOf(int[] ary, int v) {
        for (int i = 0; i < ary.length; i++) {
            if (ary[i] == v) {
                return i;
            }
        }
        return -1;
    }

    int[] copy(int[] ary, int s, int e) {
        int[] result = new int[e - s];
        for (int i = s; i < e; i++) {
            result[i - s] = ary[i];
        }
        return result;
    }
}
