/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int m = 0, n = 0;
        ListNode p1 = headA;
        ListNode p2 = headB;
        while (p1 != null) {
            m++;
            p1 = p1.next;
        }
        while (p2 != null) {
            n++;
            p2 = p2.next;
        }
        // let A be the list with the bigger length, 
        // B be the list with the smaller length
        if (m < n) {
            ListNode temp = headA;
            headA = headB;
            headB = temp;
        }
        int abs = Math.abs(m - n);
        p1 = headA;
        p2 = headB;
        for(int i = 0; i < abs; i++) {
            p1 = p1.next;
        }
        while (p1 != null) {
            if(p1 == p2) {
                return p1;
            }
            p1 = p1.next;
            p2 = p2.next;
        }
        return null;
    }
}