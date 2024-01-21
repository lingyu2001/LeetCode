class Solution {
    public int[] topKFrequent1(int[] nums, int k) {
        // store the frequency in a int[]
        // create a PQ, and sort the PQ based on the frequency
        // poll k times
        int[] frequencies = new int[20001];
        for (int i : nums) {
            frequencies[i + 10000]++;
        }
        PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        for (int i = 0; i < 20001; i++) {
            pq.offer(new Pair<Integer, Integer>(i - 10000, frequencies[i]));
        }
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = pq.remove().getKey();
        }
        return res;
    }

    public int[] topKFrequent2(int[] nums, int k) {
        // store the frequency in a HashMap
        // create a PQ, and sort the PQ based on the frequency
        // poll k times
        int[] frequencies = new int[20001];
        for (int i : nums) {
            frequencies[i + 10000]++;
        }
        PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<>((a, b) -> a.getValue() - b.getValue());
        for (int i = 0; i < 20001; i++) {
            pq.offer(new Pair<Integer, Integer>(i - 10000, frequencies[i]));
            if (pq.size() > k) {
                pq.poll();
            }
        }
        int[] res = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            res[i] = pq.poll().getKey();
        }
        return res;
    }

    public int[] topKFrequent(int[] nums, int k) {
        // calculate the frequency: val -> frequency
        // arraylist[] -> frequency ->val
        // iterate the array from back to the front, and get k elements
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        ArrayList<Integer>[] arr = new ArrayList[nums.length];
        // 这里注意arr[entry.getValue() - 1] 不是arr[entry.getValue()]
        for (Map.Entry<Integer,Integer> entry : map.entrySet()) {
            if (arr[entry.getValue() - 1] == null) {
                arr[entry.getValue() - 1] = new ArrayList<Integer>();
            }
            arr[entry.getValue() - 1].add(entry.getKey());
        }
        int[] res = new int[k];
        int p = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            ArrayList<Integer> list = arr[i];
            if(list == null) continue;
            for (int j = 0; j < list.size(); j++) {
                res[p++] = list.get(j);
                if (p == k) return res;
            }
        }
        return null;
    }

}