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
        if (list2 == null && list1 == null)
            return null;
        if (list1 != null && list2 == null )
            return list1;
        if (list2 != null && list1 == null)
            return list2;
        ListNode p1 = list1;
        ListNode p2 = list2;
        ListNode head,tail;
        head = p1.val < p2.val ? p1 : p2;
        tail = head;
        if (head == p1)
            p1 = p1.next;
        else
            p2 = p2.next;
        while(p1 != null && p2 != null) {
            if (p1.val < p2.val) {
                tail.next = p1;
                tail = tail.next;
                p1 = p1.next;
            } else {
                tail.next = p2;
                tail = tail.next;
                p2 = p2.next;
            }
        }
        if (p1 == null) {
            tail.next = p2;
        } else
            tail.next = p1;
        return head;
    }
}
