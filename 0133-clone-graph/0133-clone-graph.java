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
        if (node == null ) return null;
        // create a new node for each node
        dfs(node);
        // connect nodes
        for (Node n : map.keySet()) {
            Node nn = map.get(n);
            for (Node nei : n.neighbors) {
                nn.neighbors.add(map.get(nei));
            }
        }
        return map.get(node);
    }
    public void dfs(Node node) {
        if (!map.containsKey(node)) map.put(node, new Node(node.val, new ArrayList<Node>()));
        else return;
        for (Node n : node.neighbors) {
            dfs(n);
        }
    }
}