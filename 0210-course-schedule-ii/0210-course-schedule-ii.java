class Solution {
    HashMap<Integer, List<Integer>> map = new HashMap<>();
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // create the graph
        int[] degrees = new int[numCourses];
        for (int[] p : prerequisites) {
            int pre = p[1];
            int post = p[0];
            List<Integer> list = map.getOrDefault(pre, new ArrayList<>());
            list.add(post);
            map.put(pre,list);
            degrees[post]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < degrees.length; i++) {
            if (degrees[i] == 0) queue.offer(i);
        }
        int[] res = new int[numCourses];
        // bfs
        int index = 0;
        while (!queue.isEmpty()) {
            int k = queue.poll();
            res[index++] = k;
            if (map.containsKey(k)) {
                for (int i : map.get(k)) {
                    degrees[i]--;
                    if (degrees[i] == 0) queue.offer(i);
                }   
                // if (degrees[k] == 0) queue.offer(k);
            }
            
        }
        if (index == numCourses) return res;
        else return new int[]{};
    }
}