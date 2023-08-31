class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> length(a) - length(b));
        for (int[] p : points) {
            pq.offer(p);
        }
        int[][] res = new int[k][2];
        for (int i = 0; i < k; i++) {
            int[] p = pq.poll();
            res[i][0] = p[0];
            res[i][1] = p[1];
        }
        return res;
    }
    
    public int length(int[] p) {
        return p[0]*p[0]+p[1]*p[1];
    }
}