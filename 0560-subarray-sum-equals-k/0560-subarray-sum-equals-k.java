class Solution {
    public int subarraySum(int[] nums, int k) {
        // int[] pre = new int[nums.length + 1];
        int sum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int cnt = 0;
        for (int i = 0; i < nums.length; i++) {
            // pre[i] = pre[i - 1] + nums[i - 1];
            sum += nums[i];
            if (map.containsKey(sum - k)) {
                cnt += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum,0) + 1);
        }
        return cnt;
    }
}