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
    public ListNode partition(ListNode head, int x) {
        ListNode l = new ListNode();
        ListNode r = new ListNode();
        ListNode lp = l;
        ListNode rp = r;
        for (ListNode p = head; p != null; p = p.next) {
            ListNode temp = new ListNode(p.val);
            if (p.val < x) {
                lp.next = temp;
                lp = lp.next;
            } else {
                rp.next = temp;
                rp = rp.next;
            }
        }
        lp.next = r.next;
        return l.next;
    }
}
