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
    public ListNode removeNthFromEnd(ListNode head, int n) {}
    List<ListNode> nodes = new ArrayList<>();
        for (ListNode p = head; p != null; p = p.next) {
        nodes.add(p);
    }
    int size = nodes.size();
        if (size == 1) {
        return null;
    } else if (size == n) {
        return head.next;
    }
    ListNode target = nodes.get(size - n);
    ListNode prev = nodes.get(size - n - 1);
    prev.next = prev.next.next;
        return head;
}
}
