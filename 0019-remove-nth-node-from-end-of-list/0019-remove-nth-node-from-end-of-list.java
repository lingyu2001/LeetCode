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
        int length = 0;
        ListNode p = head;
        while (p != null) {
            p = p.next;
            length++;
        }
        if (n > length) return null;
        // calculate the target from the beginning of the list
        int index = length - n;
        if (index == 0) {
            head = head.next;
            return head;
        }
        p = head;
        // get the previous node of the target
        for (int i = 0; i < index - 1; i++) {
            p = p.next;
        }
        p.next = p.next.next;
        return head;
    }
}