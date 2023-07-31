class Solution {
    int[] visited;
    boolean flag = false;
    Map<Integer, ArrayList<Integer>> map = new HashMap<>();
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        visited = new int[numCourses];
        // create the map
        for (int i = 0; i < numCourses; i++) {
            map.put(i, new ArrayList<Integer>());
        }
        // fill in the map
        for (int i = 0; i < prerequisites.length; i++) {
            map.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }
        // detect cycles
        for (int i = 0; i < numCourses; i++) {
            if (visited[i] == 0) {
                if (isCyclic(i)) {
                    return false;
                }
            }
        }
        return true;
    }
    
    public boolean isCyclic(int i) {
        if (visited[i] == 2) return true;
        visited[i] = 2;
        for (int j = 0; j < map.get(i).size(); j++) {
            if (visited[map.get(i).get(j)] != 1)
                if (isCyclic(map.get(i).get(j))) return true;
        }
        visited[i] = 1;
        return false;
    }
}