/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        Node copiedHead = new Node(head.val);
        Node pointer = copiedHead;
        List<Node> copiedNodes = new ArrayList<>();
        List<Node> nodes = new ArrayList<>();
        copiedNodes.add(copiedHead);
        nodes.add(head);
        for (Node p = head.next; p != null; p = p.next, pointer = pointer.next) {
            pointer.next = new Node(p.val);
            copiedNodes.add(pointer.next);
            nodes.add(p);
        }
        pointer = copiedHead;
        for (Node p = head; p != null; p = p.next, pointer = pointer.next) {
            Node random = p.random;
            if (random == null) {
                continue;
            }
            pointer.random = copiedNodes.get(nodes.indexOf(random));
        }
        return copiedHead;
    }
}
