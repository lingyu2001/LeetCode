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
        ListNode p = head.next;
        head.next = null;
        ListNode next;
        while(p!=null) {
            next = p.next;
            p.next = head;
            head = p;
            p = next;
        }
        return head;
    }
}