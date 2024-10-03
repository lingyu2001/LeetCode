class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> Long.compare(b[2] , a[2]));

        for (int[] p:points) {
            long d = distance(p[0],p[1]);
            if (pq.size() < k) {
                pq.add(new long[]{p[0], p[1], d});
            } else {
                if (pq.peek()[2] > d) {
                    pq.poll();
                    pq.add(new long[]{p[0], p[1], d});
                }
            }
        }
        int[][] res = new int[k][2];
        int idx = 0;
        while (pq.size() != 0) {
            long[] peek = pq.poll();
            res[idx][0] = (int)peek[0];
            res[idx++][1] = (int)peek[1];
        }
        return res;
    }

    public Long distance (int x, int y) {
        // int x = points[i][0];
        // int y = points[i][1];
        return (long)(x*x + y*y);
    }
}