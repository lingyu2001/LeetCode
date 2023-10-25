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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode p1 = list1, p2 = list2;
        ListNode dummy = new ListNode(-101), p = dummy;
        while (p1 != null || p2 != null) {
            if (p1 != null && p2 != null) {
                if (p1.val <= p2.val) {
                    p.next = p1;
                    p1 = p1.next;
                    p.next.next = null;
                    p = p.next;
                } else {
                    p.next = p2;
                    p2 = p2.next;
                    p.next.next = null;
                    p = p.next;
                }
            } else if (p1 != null) {
                p.next = p1;
                break;
            } else {
                // p2 != null
                p.next = p2;
                break;
            }
        }
        return dummy.next;
    }
}