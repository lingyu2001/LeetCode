/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    Map<Node, Node> map = new HashMap<>();
    public Node cloneGraph(Node node) {
        cloneEachNode(node);
        connect(node);
        return map.get(node);
    }

    public void cloneEachNode(Node node) {
        if (node == null) return ;
        Node newNode = new Node(node.val);
        map.put(node, newNode);
        for (Node n : node.neighbors) {
            if (!map.containsKey(n))
                cloneEachNode(n);
        }
    }

    public void connect(Node node) {
        if (node == null) return;
        Node newNode = map.get(node);
        List<Node> list = new ArrayList<>();
        for (Node n: node.neighbors) {
            list.add(map.get(n));
        }
        newNode.neighbors = list;
        for (Node n : node.neighbors) {
            if (map.get(n).neighbors.size() == 0) connect(n);
        }
    }
}