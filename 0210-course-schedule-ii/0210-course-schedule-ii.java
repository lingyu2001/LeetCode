class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] topo = new int[numCourses];
        int[] degrees = new int[numCourses];
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int[] pre : prerequisites) {
            List<Integer> list = map.getOrDefault(pre[1], new ArrayList<>());
            list.add(pre[0]);
            map.put(pre[1], list);
            degrees[pre[0]]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (degrees[i] == 0)
                queue.offer(i);
        }
        int i = 0;
        while (!queue.isEmpty()) {
            topo[i++] = queue.poll();
            if (map.containsKey(topo[i - 1])) {
                for (int k : map.get(topo[i - 1])) {
                    degrees[k]--;
                    if (degrees[k] == 0) {
                        queue.offer(k);
                    }
                }
            }
        }
        if (i == numCourses) return topo;
        else return new int[]{};
    }
}