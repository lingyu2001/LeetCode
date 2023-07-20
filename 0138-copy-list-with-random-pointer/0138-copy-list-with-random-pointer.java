/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        // create each node
        Map<Node, Node> map = new HashMap<>();
        Node p = head;
        while (p != null) {
            Node t = new Node(p.val);
            map.put(p, t);
            p = p.next;
        }
        // link the list
        p = head;
        while (p != null) {
            Node t = map.get(p);
            t.next = map.get(p.next);
            t.random = map.get(p.random);
            p = p.next;
        }
        return map.get(head);
    }
}