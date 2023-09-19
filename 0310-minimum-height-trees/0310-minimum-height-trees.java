class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (edges.length == 0) {
            List<Integer> res = new ArrayList<>();
            res.add(0);
            return res;
        }
        int[] degree = new int[n];
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int[] e : edges) {
            Set<Integer> set1 = map.getOrDefault(e[0], new HashSet<>());
            set1.add(e[1]);
            map.put(e[0],set1);
            Set<Integer> set2 = map.getOrDefault(e[1], new HashSet<>());
            set2.add(e[0]);
            map.put(e[1],set2);
            degree[e[0]]++;
            degree[e[1]]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) 
            if (degree[i] == 1) queue.offer(i);

        int cnt = n;
        while (cnt > 2) {
            int size = queue.size();
            cnt -= size;
            for (int i = 0; i < size; i++) {
                int k = queue.poll();
                for (int j : map.get(k)) {
                    degree[j]--;
                    if (degree[j] == 1) queue.offer(j);
                }
            }
        }

        return new ArrayList<>(queue);
    }

    
}