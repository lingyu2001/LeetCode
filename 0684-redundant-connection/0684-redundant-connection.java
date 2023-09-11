class Solution {
    int[] parent;
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i + 1;
        }
        for (int[] e : edges) {
            if (find(e[0]) == find(e[1])) return new int[]{e[0],e[1]};
            else union(e[0], e[1]);
        }
        return null;
    }

    public int find(int i) {
        if (parent[i - 1] == i) return i;
        return find(parent[i - 1]);
    }

    public void union (int i, int j) {
        parent[find(i) - 1] = find(j);
    }
}