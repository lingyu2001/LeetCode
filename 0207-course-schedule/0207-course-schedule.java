class Solution {
    int[] visited;
    Map<Integer, Set<Integer>> map = new HashMap<>();
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        visited = new int[numCourses];
        for (int[] p : prerequisites) {
            Set<Integer> set1 = map.getOrDefault(p[0], new HashSet<>());
            set1.add(p[1]);
            map.put(p[0],set1);
        }
        for (int i = 0; i < numCourses; i++) {
            boolean flag = false;
            if (visited[i] == 0) {
                flag = dfs(i);
                if (!flag) return false;
            } else if (visited[i] == 1) continue;
        }
        return true;
    }

    public boolean dfs(int i) {
        if (visited[i] == 1) return true;
        if (visited[i] == 2) return false;
        visited[i] = 2;
        Set<Integer> set = map.get(i);
        if (set != null)
            for (int j : set) {
                if (!dfs(j)) return false;
            }
        visited[i] = 1;
        return true;
    }
}