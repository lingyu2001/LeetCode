class Solution {
    int[] parent;
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i + 1;
        }
        for (int[] e : edges) {
            if (find(e[0]) == find(e[1])) return e;
            union(e[0], e[1]);
        }
        return new int[]{};
    }

    public int find(int k) {
        if (parent[k - 1] == k) return k;
        else return find(parent[k - 1]);
    }

    public void union(int i, int j) {
        parent[find(j) - 1] = find(i);
    }
}