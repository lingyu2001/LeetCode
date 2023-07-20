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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(), p = head, p1 = l1, p2 = l2;
        int d = 0, sum = 0, k = 0;
        while (p1 != null || p2 != null) {
            int t = (p1 != null? p1.val:0) + (p2 != null? p2.val:0);
            p.val = (t + d) % 10;
            sum = (int)Math.pow(10,k) * p.val + sum;
            p.next = new ListNode();
            p = p.next;
            k++;
            d = (t + d) / 10;
            if (p1 != null) p1 = p1.next;
            if (p2 != null) p2 = p2.next;
        }
        if (d > 0) {
            p.val = d;
            p.next = new ListNode();
            p = p.next;
        }
        // delete the last 0
        ListNode t1 = head;
        while (!(t1.next != null && t1.next.next == null)) {
            // System.out.print(t1.val);
            t1 = t1.next;
        }
        // System.out.println();
        t1.next = null;
        // System.out.println(head.val);
        // if (sum != 0) {
        //     ListNode t = head;
        //     while (t != null && t.val == 0) {
        //         t = t.next;
        //     }
        //     return t;
        // }
        return head;
    }
}