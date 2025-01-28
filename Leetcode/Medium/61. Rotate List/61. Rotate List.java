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
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return head;
        }
        List<ListNode> nodes = new ArrayList<>();
        for (ListNode p = head; p != null; p = p.next) {
            nodes.add(p);
        }
        int n = nodes.size();
        k = k % n;
        if (n == 1 || k == 0) {
            return head;
        }
        ListNode prev = nodes.get(n - k - 1);
        prev.next = null;
        ListNode last = nodes.get(n - 1);
        last.next = nodes.get(0);
        return nodes.get(n - k);
    }
}
