class Solution {
    Map<Integer, HashSet<Integer>> map = new HashMap<>();
    int[] visited;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        visited = new int[numCourses];
        for (int[] e : prerequisites) {
            HashSet<Integer> set = map.getOrDefault(e[0], new HashSet<>());
            set.add(e[1]);
            map.put(e[0], set);
        }
        for (int i = 0; i < numCourses; i++) {
            if (visited[i] == 0) if (!dfs(i)) return false;
        }
        return true;
    }

    public boolean dfs(int i) {
        if (visited[i] == 1) return true;
        if (visited[i] == 2) return false;
        Set<Integer> neighbors = map.get(i);
        visited[i] = 2;
        if (neighbors != null) {
            for (int n : neighbors) {
                if(!dfs(n)) return false;
            }
        }
        visited[i] = 1;
        return true;
    }
}