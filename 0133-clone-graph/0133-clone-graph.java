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
        dfs(node);
        // for (Map.Entry<Node,Node> key : map.entrySet()) {
        //     System.out.println(key.getKey() + " " + key.getValue());
        //     System.out.println(key.getKey().val + " " + key.getValue().val);
        //     System.out.println("-----");
        // }
        Node ret =  copy(node);
        // for (Map.Entry<Node,Node> key : map.entrySet()) {
        //     System.out.println(key.getKey() + " " + key.getValue());
        //     System.out.println(key.getKey().val + " " + key.getValue().val);
        //     System.out.println("-----");
        // }
        // for (Map.Entry<Node,Node> key : map.entrySet()) {
        //     for (Node n : key.getKey().neighbors) {
        //         System.out.println(key.getKey().val + " " + n.val + " " + n);
        //     }
        //     System.out.println("-----");
        // }
        return ret;
    }
    
    public void dfs(Node node) {
        if (node == null) return;
        if (map.containsKey(node)) return;
        Node newNode = new Node(node.val);
        map.put(node, newNode);
        for (Node n : node.neighbors) {
            dfs(n);
        }
    }
    
    public Node copy(Node node) {
        if (node == null) return null;
        Node nNode = map.get(node);
        if (!nNode.neighbors.isEmpty()) return nNode;
        nNode.neighbors = new ArrayList<Node>();
        for (Node n: node.neighbors) {
            // System.out.println(map.get(n));
            nNode.neighbors.add(map.get(n));
        }
        for (Node n: node.neighbors) {
            copy(n);
        }
        return nNode;
    }
}