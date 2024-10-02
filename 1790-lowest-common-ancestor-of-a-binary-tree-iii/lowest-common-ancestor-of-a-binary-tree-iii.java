/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
};
*/

class Solution {
    public Node lowestCommonAncestor(Node p, Node q) {
        HashSet<Node> set = new HashSet<>();
        set.add(p);
        set.add(q);
        Node parent = p.parent;
        while (parent != null) {
            if (!set.add(parent)) {
                return parent;
            }
            parent = parent.parent;
        }
        parent = q.parent;
        while (parent != null) {
            if (!set.add(parent)) {
                return parent;
            }
            parent = parent.parent;
        }
        return null;
    }
}