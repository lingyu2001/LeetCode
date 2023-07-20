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
        ListNode dummy = new ListNode(0,head), p = dummy;
        int cnt = 0;
        while (p.next != null) {
            p = p.next;
            cnt++;
        }
        // System.out.println(cnt);
        p = dummy;
        int index = cnt - n;
        cnt = 0;
        while (cnt < index) {
            p = p.next;
            cnt++;
        }
        p.next = p.next.next;
        return dummy.next;
    }
}