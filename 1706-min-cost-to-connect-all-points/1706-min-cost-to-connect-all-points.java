class Solution {
    public int minCostConnectPoints(int[][] points) {
        // add edges and distance to priority queue
        // poll an edge and connect the points if there isn't a cycle
        // if there is a cycle, continue
        int n = points.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0] - b[0]);
        Set<Integer> set = new HashSet<>();
        pq.offer(new int[]{0, 0});
        int cost = 0;
        while (set.size() < n) {
            int[] t = pq.poll();
            int weight = t[0];
            int currNode = t[1];
            if (set.contains(currNode)) continue;
            set.add(currNode);
            cost += weight;
            for (int i = 0; i < n; i++) {
                if (set.contains(i)) continue;
                pq.offer(new int[] {
                    Math.abs(points[currNode][0] - points[i][0]) + 
                    Math.abs(points[currNode][1] - points[i][1]),
                    i
                });
            }
        }
        return cost;
    }
}