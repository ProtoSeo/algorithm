/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {

    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        Deque<Node> q = new ArrayDeque<>();
        q.add(root);
        while(!q.isEmpty()) {
            Deque<Node> nextLevel = new ArrayDeque<>();
            while (!q.isEmpty()) {
                Node node = q.pollFirst();
                if (node == null) {
                    continue;
                }
                if (node.left != null) {
                    nextLevel.addLast(node.left);
                }
                if (node.right != null) {
                    nextLevel.addLast(node.right);
                }
                if (!q.isEmpty()) {
                    Node next = q.peekFirst();
                    if (next != null) {
                        node.next = next;
                    }
                }
            }
            while (!nextLevel.isEmpty()) {
                q.addLast(nextLevel.pollFirst());
            }
        }
        return root;
    }
}
