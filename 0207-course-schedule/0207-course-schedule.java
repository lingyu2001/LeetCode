class Solution {
    int[] used;
    Map<Integer, ArrayList<Integer>> map = new HashMap<>();
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // create a map
        for (int i = 0; i < numCourses; i++) {
            map.put(i, new ArrayList<Integer>());
        }
        for (int[] pre : prerequisites) {
            map.get(pre[0]).add(pre[1]);
        }
        used = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (isCyclic(prerequisites, i)) return false;
        }
        return true;
    }
    
    public boolean isCyclic(int[][] prerequisites, int n) {
        if (used[n] == 2) {
            return true;
        } else if (used[n] == 1) return false;
        used[n] = 2;
        ArrayList<Integer> list = map.get(n);
        for (int i = 0; i < list.size(); i++) {
                if (isCyclic(prerequisites, list.get(i))) {
                    return true;
                }
        }
        used[n] = 1;
        return false;
    }
}