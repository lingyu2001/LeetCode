class Solution {
    HashMap<Integer, List<int[]>> map = new HashMap<>();
    public int networkDelayTime(int[][] times, int n, int k) {
        for (int i = 1; i <= n; i++ )
            map.put(i, new ArrayList<int[]>());
        // create the graph
        for(int[] e : times) {
            List<int[]> list = map.getOrDefault(e[0], new ArrayList<>());
            list.add(new int[]{e[1], e[2]});
            map.put(e[0], list);
        }
        // run dijkstra 
        PriorityQueue<int[]> pq = new PriorityQueue<>( (a,b) -> a[1] - b[1]);
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;
        pq.offer(new int[]{k, 0}); 
        while (!pq.isEmpty()) {
            int[] t = pq.poll();
            int id = t[0];
            int distStart = t[1];
            if (distStart > dist[id]) continue;
            for (int[] nei : map.get(id)) {
                if (distStart + nei[1] < dist[nei[0]]) {
                    dist[nei[0]] = distStart + nei[1];
                    pq.offer(new int[] {nei[0], dist[nei[0]]});
                }
            }
        }
        int cnt = 0;
        for (int i = 1; i<= n; i++) {
            if (dist[i] == Integer.MAX_VALUE) return -1;
            cnt = Math.max(cnt, dist[i]);
        }
        return cnt;
    }
}