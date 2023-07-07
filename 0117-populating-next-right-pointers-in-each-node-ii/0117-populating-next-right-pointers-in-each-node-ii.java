/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        Queue<Node> q = new ArrayDeque<>();
        if (root != null) q.offer(root);
        while (!q.isEmpty()) {
            int size = q.size();
            // poll a node
            Node cur = q.poll();
            // add its children to queue
            if (cur.left != null) q.add(cur.left);
            if (cur.right != null) q.add(cur.right);
            // iterate the whole nodes at this level, and connect them
            for (int i = 1; i < size; i++) {
                Node next = q.poll();
                cur.next = next;
                if (next.left != null) q.offer(next.left);
                if (next.right != null) q.offer(next.right);
                cur = next;
            }
        }
        return root;
    }
}