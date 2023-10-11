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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode s = head;
        ListNode f = head;
        if (head == null) return null;
        HashSet<Integer> set = new HashSet<>();
        while (f != null) {
            if (set.add(f.val)) {
                s.val = f.val;
                s = s.next;
                f = f.next;
            } else {
                f = f.next;
            }
        }
        ListNode p = head;
        while (p.next != s) {
            p = p.next;
        }
        p.next = null;
        return head;
    }
}