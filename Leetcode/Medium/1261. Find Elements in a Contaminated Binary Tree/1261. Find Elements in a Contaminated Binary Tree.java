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
class FindElements {

    Set<Integer> cache = new HashSet<>();

    public FindElements(TreeNode root) {
        if (root == null) {
            return;
        }
        findElementsWithIndex(root, 0);
    }

    private void findElementsWithIndex(TreeNode root, int value) {
        if (root == null) {
            return;
        }
        cache.add(value);
        if (root.left != null) {
            findElementsWithIndex(root.left, value * 2 + 1);
        }
        if (root.right != null) {
            findElementsWithIndex(root.right, value * 2 + 2);
        }
    }

    public boolean find(int target) {
        return cache.contains(target);
    }
}

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */
