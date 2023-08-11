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
    public ListNode reverseList(ListNode head) {
        if (head == null) return null;
        ListNode p = reverseList(head.next);
        ListNode head1 = p == null? head:p;
        while (p != null && p.next != null) {
            p = p.next;
        }
        if (p == null) p = head;
        else p.next = head;
        head.next = null;
        return head1;
    }
}