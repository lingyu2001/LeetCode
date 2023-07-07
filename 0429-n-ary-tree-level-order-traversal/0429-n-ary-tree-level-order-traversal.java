/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> level = new ArrayList<>();
    Queue<Node> q = new ArrayDeque<>();
    public List<List<Integer>> levelOrder(Node root) {
        if (root != null) q.offer(root);
        while (!q.isEmpty()) {
            int size = q.size();
            for (;size > 0; size--) {
                Node t = q.poll();
                level.add(t.val);
                if (t.children == null || t.children.size() == 0) continue;
                for (int i = 0; i < t.children.size(); i++) {
                    if (t.children.get(i) != null)
                        q.offer(t.children.get(i));
                }
            }
            res.add(new ArrayList<>(level));
            // System.out.println(level.toString());
            level.clear();
        }
        return res;
    }
}