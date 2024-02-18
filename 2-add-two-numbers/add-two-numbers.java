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
        int digit = 0;
        ListNode p1 = l1, p2 = l2, dummy = new ListNode(), p3 = dummy;
        while (p1 != null || p2 != null) {
            int v1 = 0, v2 = 0;
            if (p1 != null) {
                v1 = p1.val;
                p1 = p1.next;
            }
            if (p2 != null) {
                v2 = p2.val;
                p2 = p2.next;
            }
            int value = (v1 + v2 + digit) % 10;
            digit = (v1 + v2 + digit) / 10;
            p3.next = new ListNode(value);
            p3 = p3.next;
        }
        if (digit != 0) {
            p3.next = new ListNode(digit);
        }
        return dummy.next;
    }
}