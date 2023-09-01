class Solution {
    public int leastInterval(char[] tasks, int n) {
        int time = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b- a);
       Queue<Pair<Integer, Integer>> q = new LinkedList<>();
        int[] arr = new int[26];
        for (char c: tasks) arr[c - 'A']++;
        for (int i : arr) if (i > 0) pq.offer(i);
        
        while (!pq.isEmpty() || !q.isEmpty()) {
            time++;
            if (!pq.isEmpty()) {
                int val = pq.poll();
                val--;
                if (val > 0) q.offer(new Pair(val, time + n));
            }
            if (!q.isEmpty() && q.peek().getValue() == time) {
                pq.add(q.poll().getKey());
            }
        }
        return time;
    }
}