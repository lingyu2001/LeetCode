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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode p1 = l1, p2 = l2;
        int digit = 0;
        ListNode head = new ListNode();
        ListNode p = head;
        while (p1 != null || p2 != null) {
            int p1val = p1 == null ? 0 : p1.val;
            int p2val = p2 == null ? 0 : p2.val;
            p.val = (p1val + p2val + digit) % 10;
            digit = (p1val + p2val + digit) / 10;
            p1 = p1 == null ? null : p1.next;
            p2 = p2 == null ? null : p2.next;
            if (p1 != null || p2 != null) {
                p.next = new ListNode();
                p = p.next;
            }
        }
        if (digit != 0) p.next = new ListNode(digit);
        return head;
    }
}