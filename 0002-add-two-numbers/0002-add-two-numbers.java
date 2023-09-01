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
        int res = 0;
        ListNode head = new ListNode();
        ListNode t = head;
        ListNode p = l1, q = l2;
        while (p != null || q != null) {
            res *= 10;
            int pval = p == null? 0 : p.val;
            int qval = q == null? 0 : q.val;
            t.val = (pval + qval + digit) % 10;
            digit = (pval + qval + digit) / 10;
            p = p == null ? null : p.next;
            q = q == null ? null : q.next;
            if (p != null || q != null) {
                t.next = new ListNode();
                t = t.next;
            }
        }
        if (digit > 0) {
            t.next = new ListNode(digit);
        }
        
        return head;
    }
}