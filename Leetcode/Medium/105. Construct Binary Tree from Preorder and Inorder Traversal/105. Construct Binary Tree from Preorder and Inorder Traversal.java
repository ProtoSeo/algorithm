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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0) {
            return null;
        }
        int value = preorder[0];
        int idx = indexOf(inorder, value);
        return new TreeNode(value,
                buildTree(copy(preorder, 1, 1 + idx), copy(inorder, 0, idx)),
                buildTree(copy(preorder, 1 + idx, preorder.length), copy(inorder, idx + 1, inorder.length))
        );
    }

    int indexOf(int[] ary, int value) {
        for (int i = 0; i < ary.length; i++) {
            if (ary[i] == value) {
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
