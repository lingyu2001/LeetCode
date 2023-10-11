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
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;
        ListNode dummy = new ListNode(-101, head), s = dummy;
        ListNode f = head;
        while (f != null) {
            int cnt = 1;
            while (f.next != null && f.next.val == f.val) {
                cnt++;
                f = f.next;
            }
            if (s != f && cnt == 1) {
                s.next = f;
                s = f;
            }
            f = f.next;
        }
        s.next = null;
        return dummy.next;
    }
}