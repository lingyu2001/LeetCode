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
        Node parent = p;
        while (parent != null) {
            if (!set.add(parent)) {
                return parent;
            }
            parent = parent.parent;
        }
        parent = q;
        while (parent != null) {
            if (!set.add(parent)) {
                return parent;
            }
            parent = parent.parent;
        }
        return null;
    }
}