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
    public ListNode reverseKGroup(ListNode head, int k) {
        if (k == 1) {
            return head;
        }
        ListNode root = new ListNode();
        root.next = head;
        ListNode start = head;
        ListNode prev = root;
        while (hasGroup(start, k)) {
            ListNode node = start;
            ListNode next = start.next;
            for (int i = 0; i < k - 1; i++) {
                ListNode temp = next;
                next = next.next;
                temp.next = node;
                node = temp;
            }
            prev.next = node;
            prev = start;
            start.next = next;
            start = next;
        }
        return root.next;
    }

    boolean hasGroup(ListNode node, int k) {
        int cnt = 0;
        ListNode temp = node;
        while (temp != null && cnt < k) {
            cnt++;
            temp = temp.next;
        }
        return cnt == k;
    }
}
