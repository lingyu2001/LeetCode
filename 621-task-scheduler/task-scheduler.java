class Solution {
    public int leastInterval(char[] tasks, int n) {
        // A: 1, B: 5, n = 2
        // BA_B_ _B_ _B_ _B => pq [the num of tasks, when i can start the task]
        // 1. count the frequency of each tasks
        // time = 0
        // 2. give priority to the earlist time, and then num of tasks
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]> () {
            public int compare(int[] a, int[] b) {
                if (a[0] == b[0]) {
                    return a[1] - b[1];
                }
                //give priority to ealiest time
                return b[0] - a[0];
            }
        });

        // store info to the pq
        // get frequency
        int[] f = new int[26];
        for (char c : tasks) {
            f[c - 'A']++;
        }
        int time = 0;
        for (int i : f) {
            if (i > 0)
                pq.add(new int[]{i, time});
        }
        while (pq.size() != 0) {
            time++;
            // store the tasks that cant be sheduled rn
            List<int[]> list = new ArrayList<>();
            while (!pq.isEmpty() && pq.peek()[1] > time) {
                list.add(pq.poll());
            }
            if (!pq.isEmpty()) {
                // the peek is the shceduled task
                int[] t = pq.poll();
                if (t[0] == 1) {
                } else {
                    pq.add(new int[]{t[0]-1, time + n + 1});
                }
            }
            for (int[] t: list) {
                pq.add(t);
            }
        }
        return time;
    }
}