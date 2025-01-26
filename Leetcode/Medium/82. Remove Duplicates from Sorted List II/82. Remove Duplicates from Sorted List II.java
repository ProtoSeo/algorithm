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
    public ListNode deleteDuplicates(ListNode head) {
        Map<Integer, Integer> count = new TreeMap<>();
        for (ListNode p = head; p != null; p = p.next) {
            count.put(p.val, count.getOrDefault(p.val, 0) + 1);
        }
        ListNode result = new ListNode();
        ListNode p = result;
        for (int key : count.keySet()) {
            if (count.get(key) == 1) {
                p.next = new ListNode(key);
                p = p.next;
            }
        }
        return result.next;
    }
}
