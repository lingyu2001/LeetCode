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
        // find the middle node
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        // reverse the second half
        ListNode cur = slow.next;
        ListNode prev = null;
        slow.next = null;
        ListNode next = null;
        while (cur != null) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        // merge
        ListNode head1 = head, head2 = prev;
        while (head2 != null) {
            ListNode tmp1 = head1.next;
            ListNode tmp2 = head2.next;
            head1.next = head2;
            head2.next = tmp1;
            head1 = tmp1;
            head2 = tmp2;
        }
    }
}