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
        // corner case : len(list1) == 0 or len(list2) == 0
        // iterate list1 and list2, p1 points to nodes in list1, p2 points to nodes in list2
        // if (p1.val < p2.val) then 
        // else t= p1; p1 = p1.next; move t after p2, then let p2 = t;
        if (list1 == null) return list2;
        else if (list2 == null) return list1;
        ListNode p1 = list1, p2 = list2;
        if (list1.val < list2.val) {
            p2 = list1;
            p1 = list2;
        } else {
            p1 = list1;
            p2 = list2;
        }
        ListNode head = p2;
        while (p1 != null && p2 != null && p2.next != null) {
            if (p1.val <= p2.next.val) {
                ListNode t = p1;
                p1 = p1.next;
                t.next = p2.next;
                p2.next = t;
                p2 = t;
            } else {
                p2 = p2.next;
            }
        }
        if (p1 != null) {
            p2 = head;
            while (p2.next != null) p2 = p2.next;
            p2.next = p1;
        }
        return head;
    }
}