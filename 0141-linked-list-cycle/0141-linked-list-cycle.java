/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null) return false;
        Set<ListNode> set = new HashSet<>();
        ListNode p = head;
        while (p != null) {
            if (!set.add(p)) return true;
            p = p.next;
        }
        return false;
    }
}