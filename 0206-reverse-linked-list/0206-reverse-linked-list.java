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
        ListNode before = null;
        if (head == null) return null;
        ListNode cur = head, next = head.next;
        while (cur != null) {
            next = cur.next;
            cur.next = before;
            before = cur;
            cur = next;
        }
        return before;
    }
}