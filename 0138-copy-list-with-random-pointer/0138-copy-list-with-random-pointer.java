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
    Map<Node, Node> map = new HashMap<>();
    public Node copyRandomList(Node head) {
        if (head == null) return null;
        //copy
        Node p = head;
        while (p != null) {
            map.put(p, new Node(p.val));
            p = p.next;
        }
        // connect
        p = head;
        while (p != null) {
            Node newNode = map.get(p);
            newNode.next = map.get(p.next);
            newNode.random = map.get(p.random);
            p = p.next;
        }
        return map.get(head);
    }
}