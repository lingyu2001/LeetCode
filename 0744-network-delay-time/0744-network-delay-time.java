class State {
    int id;
    int dist;
    public State(int id, int dist) {
        this.id = id;
        this.dist = dist;
    }
}
class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        // create a graph
        List<int[]>[] graph = new LinkedList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new LinkedList<>();
        }
        for (int[] e : times) {
            int curNode = e[0];
            int tgtNode = e[1];
            graph[curNode].add(new int[]{tgtNode, e[2]});
        }
        PriorityQueue<State> pq = new PriorityQueue<>((a, b) -> a.dist - b.dist);
        int[] fromStartToK = new int[n + 1];
        Arrays.fill(fromStartToK, Integer.MAX_VALUE);
        fromStartToK[k] = 0;
        pq.offer(new State(k, 0));
        while(!pq.isEmpty()) {
            State s = pq.poll();
            int curr = s.id;
            int dist = s.dist;
            if (dist > fromStartToK[curr]) continue;
            for (int nei[] : graph[curr]) {
                if (fromStartToK[nei[0]] > nei[1] + dist) {
                    fromStartToK[nei[0]] = nei[1] + dist;
                    pq.offer(new State(nei[0], nei[1] + dist));
                }
            }
        }
        int res = 0;
        for (int i = 1; i <= n; i++) {
            if (fromStartToK[i] == Integer.MAX_VALUE) return -1;
            else res = Math.max(res, fromStartToK[i]);
        }
        return res;
    }

}