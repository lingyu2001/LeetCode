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
    HashMap<Node, Node> map = new HashMap<>();
    public Node copyRandomList(Node head) {
        // 1. create a copy node for each node in the list
        copy(head);
        // 2. do DFS on the list and connect them with next nodes;
        connectNext(head);
        // 3. connect the list with random nodes;
        connectRandom(head);
        return map.getOrDefault(head, null);
    }

    public void copy(Node head) {
        Node p = head;
        while (p != null) {
            Node newNode = new Node(p.val);
            map.put(p, newNode);
            p = p.next;
        }
    }

    public void connectNext(Node head) {
        Node p = head;
        // iteration
        while (p != null) {
            Node copy = map.get(p);
            Node nextNode = map.get(p.next);
            // connect these two nodes
            copy.next = nextNode;
            p = p.next;
        }
    }

    public void connectRandom(Node head) {
        Node p = head;
        // iteration
        while (p != null) {
            Node copy = map.get(p);
            Node nextNode = map.get(p.random);
            // connect these two nodes
            copy.random = nextNode;
            p = p.next;
        }
    }
}