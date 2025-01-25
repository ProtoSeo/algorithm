/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || left == right) {
            return head;
        }
        List<ListNode> nodes = new ArrayList<>();
        for (ListNode p = head; p != null; p = p.next) {
            nodes.add(p);
        }
        List<ListNode> newNodes = new ArrayList<>();
        int idx = right - 1;
        for (int i = 0; i < nodes.size(); i++) {
            if (left - 1 <= i && i <= right - 1) {
                newNodes.add(nodes.get(idx--));
            } else {
                newNodes.add(nodes.get(i));
            }
        }

        ListNode newHead = new ListNode();
        for (int i = 0; i < newNodes.size(); i++) {
            ListNode node = newNodes.get(i);
            if (i == 0) {
                newHead = node;
            } else if (i == newNodes.size() - 1) {
                node.next = null;
                break;
            }
            node.next = newNodes.get(i + 1);
        }
        return newHead;
    }
}
