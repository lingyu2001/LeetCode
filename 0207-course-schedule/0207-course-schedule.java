class Solution {
    HashMap<Integer, List<Integer>> map = new HashMap<>();
    int[] detected;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        for (int i = 0; i < numCourses; i++) {
            map.put(i, new ArrayList<>());
        }
        // create a graph for this case
        for (int[] pre : prerequisites) {
            List<Integer> list = map.getOrDefault(pre[0], new ArrayList<>());
            list.add(pre[1]);
            map.put(pre[0], list);
        }
        detected = new int[numCourses];
        // try dfs in this graph, 
        // if there is a cycle => return false;
        // else return true;
        for (int i : map.keySet()) {
            if (isCycle(i)) return false;
        }
        return true;
    }

    public boolean isCycle(int i) {
        if (detected[i] == 2) return false;
        if (detected[i] == 1) return true;
        detected[i] = 1;
        boolean res = false;
        for (int n : map.get(i)) {
            res = res || isCycle(n);
        }
        detected[i] = 2;
        return res;
    }
} 