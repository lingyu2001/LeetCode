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
        if (list1 == null && list2 == null) return null;
        else if (list1 == null) return list2;
        else  if (list2 == null) return list1;
        ListNode p1 = list1, p2 = list2;
        ListNode dummy = new ListNode(), p = dummy;
        while (p1 != null && p2 != null) {
            if (p1.val < p2.val) {
                p.next = new ListNode(p1.val);
                p = p.next;
                p1 = p1.next;
            } else {
                p.next = new ListNode(p2.val);
                p = p.next;
                p2 = p2.next;
            }
        }
        while (p1 != null) {
            p.next = new ListNode(p1.val);
            p = p.next;
            p1 = p1.next;
        }
        while (p2 != null) {
            p.next = new ListNode(p2.val);
            p = p.next;
            p2 = p2.next;
        }
        return dummy.next;
    } 
}