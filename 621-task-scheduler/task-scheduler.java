class Solution {
    public int leastInterval(char[] tasks, int n) {
        int time = 0;
        int[] cnt = new int[26];
        for (char c : tasks) {
            cnt[c - 'A']++;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b - a);
        for (int i : cnt) {
            if (i > 0) pq.add(i);
        }
        // q stores the earlist time that tasks are waiting to be scheduled
        Queue<Pair<Integer, Integer>> q = new LinkedList<>();
        // pq stores the tasks that can be scheduled immediately
        while (!pq.isEmpty() || !q.isEmpty()) {
            time++;
            if (!pq.isEmpty()) {
                int val = pq.poll();
                val--;
                if (val > 0) {
                    q.add(new Pair(val, time + n));
                }
            }
            if (!q.isEmpty() && q.peek().getValue() == time) {
                pq.add(q.poll().getKey());
            }
        }
        return time;
    }
}