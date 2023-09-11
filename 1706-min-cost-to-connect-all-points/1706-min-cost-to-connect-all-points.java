class Solution {
    public int minCostConnectPoints(int[][] points) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0] - b[0]);
        pq.offer(new int[]{0 ,0});
        int cost = 0;
        Set<Integer> set = new HashSet<>();
        int n = points.length;
        while (set.size() < n) {
            int[] cur = pq.poll();
            int curNode = cur[1];
            int curWeight = cur[0];
            if (set.contains(curNode)) continue;
            cost += curWeight;
            set.add(curNode);
            for (int i = 0; i < n; i++) {
                if (set.contains(i)) continue;
                pq.offer(new int[] { Math.abs(points[curNode][0] - points[i][0]) + 
                Math.abs(points[curNode][1] - points[i][1])
                , i});
            }
        }
        return cost;
    }
}