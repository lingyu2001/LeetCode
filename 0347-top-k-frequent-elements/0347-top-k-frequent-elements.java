class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i : nums) {
            map.put(i, map.getOrDefault(i,0) + 1);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (pair1,pair2) -> pair2[1] - pair1[1]
        );
        for (Map.Entry<Integer,Integer> e: map.entrySet()) {
            pq.add(new int[]{e.getKey(),e.getValue()});
        }
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = pq.poll()[0];
            
        }
        return res;
    }
}