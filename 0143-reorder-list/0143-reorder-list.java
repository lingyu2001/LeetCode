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
    public void reorderList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) return;
        ListNode p1 = head, p2 = head, p3 = p1.next;
        while (p2.next != null && p2.next.next != null) p2 = p2.next;
        ListNode last = p2.next;
        p2.next = null;
        p1.next = last;
        last.next = p3;
        reorderList(p3);
    }
}