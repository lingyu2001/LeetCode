class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] dist = new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[src] = 0;
        for (int i = 0; i <= k; i++) {
            int[] temp = new int[n];
            System.arraycopy(dist, 0, temp, 0, n);
            for (int j = 0; j < flights.length; j++) {
                int s = flights[j][0];
                int d = flights[j][1];
                int p = flights[j][2];
                if (dist[s] == Integer.MAX_VALUE) continue;
                if (dist[s] + p < temp[d]) {
                    temp[d] = dist[s] + p; 
                }
            }
            dist = temp;
        }
        return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];
    }
}