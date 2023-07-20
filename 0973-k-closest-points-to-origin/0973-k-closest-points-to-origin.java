class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->-Integer.compare(a[0]*a[0] + a[1]*a[1],
                b[0]*b[0] + b[1]*b[1])
        );
        for (int i = 0; i < points.length; i++) {
            if (pq.size() < k) pq.add(points[i]);
            else {
                if (dis(points[i])< dis(pq.peek())) {
                    pq.poll();
                    pq.add(points[i]);
                }
            }
        }
        
        int[][] ans = new int[k][2];
        for(int i = 0; i < k; i++) {
            int[]t = pq.poll();
            ans[i][0] = t[0];
            ans[i][1] = t[1];
        }
        return ans;
    }
    
    public int dis(int[] p) {
        return p[0] * p[0] + p[1] * p[1];
    }
}