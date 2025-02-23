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
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        if (preorder.length == 0) {
            return null;
        } else if (preorder.length == 1) {
            return new TreeNode(preorder[0]);
        }
        TreeNode root = new TreeNode(preorder[0]);
        int li = indexOf(postorder, preorder[1]);
        root.left = constructFromPrePost(copy(preorder, 1, 1 + li + 1), copy(postorder, 0, li + 1));
        if (preorder[1] != postorder[postorder.length - 2]) {
            int ri = indexOf(preorder, postorder[postorder.length - 2]);
            root.right = constructFromPrePost(copy(preorder, ri, preorder.length), copy(postorder, li + 1, postorder.length - 1));
        }
        return root;
    }

    int indexOf(int[] ary, int val) {
        for (int i = 0; i < ary.length; i++) {
            if (ary[i] == val) {
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
