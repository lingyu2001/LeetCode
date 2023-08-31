class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->(b[0]*b[0] + b[1]*b[1]) - (a[0]*a[0]+a[1]*a[1]));
        for (int[] p : points) {
            if (pq.size() < k) pq.offer(p);
            else {
                int len = p[0] * p[0] + p[1] * p[1];
                if (len < length(pq.peek())) {
                    pq.poll();
                    pq.offer(p);
                }
            }
        }
        int[][] res = new int[k][2];
        int index = 0;
        for (int[] p : pq) {
            res[index++] = p;
        }
        return res;
    }
    
    public int length(int[] p) {
        return p[0]*p[0]+p[1]*p[1];
    }
}