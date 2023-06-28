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
        ListNode head1 = reverseList(head.next) , p = head1;
        if (head1 == null) return head;
        while(p.next != null) {
            p = p.next;
        }
        p.next = head;
        head.next = null;
        return head1;
    }
}