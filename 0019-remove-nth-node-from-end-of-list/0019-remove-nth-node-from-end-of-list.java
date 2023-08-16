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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // count the total number of the nodes in the list
        ListNode p = head;
        int cnt = 0;
        while (p != null) {
            p = p.next;
            cnt++;
        }
        if (cnt <= 1) return null;
        int order = cnt - n;
        ListNode dummy = new ListNode();
        dummy.next = head;
        p = dummy;
        while (order > 0) {
            p = p.next;
            order--;
        }
        p.next = p.next.next;
        return dummy.next;
    }
}