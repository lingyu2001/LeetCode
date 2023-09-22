class Solution {
    public int leastInterval(char[] tasks, int n) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b - a);
        Queue<Pair<Integer, Integer>> q = new LinkedList<>();
        int time = 0;
        int[] arr = new int[26];
        for (char c : tasks) arr[c - 'A']++;
        for (int i = 0; i < 26; i++) if (arr[i] > 0) pq.offer(arr[i]);
        while (!pq.isEmpty() || !q.isEmpty()) {
            time++;
            if (!pq.isEmpty()) {
                int val = pq.poll();
                val--;
                if (val >= 1)  q.offer(new Pair(val, time + n));
            }
            if (!q.isEmpty() && q.peek().getValue() == time) {
                pq.offer(q.poll().getKey());
            }
        }
        return time;
    }
}