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
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) return null;
        ListNode dummy = new ListNode(0, head), p = dummy, pre = p;
        while (p != null) {
            if (p.val == val) {
                pre.next = p.next;
            } else {
                pre = p;
            }
            p = p.next;
        }
        head = dummy.next;
        return head;
    }
}