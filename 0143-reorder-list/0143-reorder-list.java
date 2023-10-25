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
        ListNode curr = head;
        while (curr != null && curr.next != null) {
            ListNode next = curr.next;
            ListNode pre = curr;
            while (pre.next.next != null) {
                pre = pre.next;
            } 
            if (pre == curr) return ;
            ListNode last = pre.next;
            curr.next = last;
            pre.next = null;
            last.next = next;
            curr = next;
        }
    }
}