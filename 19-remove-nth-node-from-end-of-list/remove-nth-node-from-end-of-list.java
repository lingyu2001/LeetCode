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
        // method 1 : 1. get the full length of the list l . 2. the last nth node <=> the first l - n + 1
        // method 2 : create a dummy node ; we have a pointer p1, it points at the nth node in the list(without dummy node). pointer p2 pointed at the head of the list
                    // and then we keep moving the p1 and p2 at the same time until p2 reaches the null 
        ListNode p1 = head, dummy = new ListNode(-1, head), p2 = dummy;
        int cnt = 1;
        while (true) {
            if (cnt == n) break;
            else {
                p1 = p1.next;
                cnt++;
            }
        }
        while (p1.next != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        // p2 points at the node in front of the last nth node
        ListNode nthNode = p2.next;
        p2.next = nthNode.next;
        return dummy.next;
    }
}