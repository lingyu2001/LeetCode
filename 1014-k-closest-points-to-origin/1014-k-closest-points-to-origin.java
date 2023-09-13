class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Pair<int[], Integer>> pq = new PriorityQueue<>((a,b) -> b.getValue() - a.getValue());
        for (int[] p : points) {
            int dis = p[0] * p[0] + p[1] * p[1];
            if (pq.size() < k) pq.offer(new Pair(p, dis));
            else {
                if (pq.peek().getValue() > dis) {
                    pq.poll();
                    pq.offer(new Pair(p, dis));
                }
            }
        }
        int[][] res = new int[k][2];
        for (int i = 0; i < k; i++) {
            int[] p = pq.poll().getKey();
            res[i][0] = p[0];
            res[i][1] = p[1];
        }
        return res;
    }
}