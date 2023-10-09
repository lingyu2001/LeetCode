class Solution {
    public int findMaxLength(int[] nums) {
        int sum = 0;
        int max = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] == 0 ? -1 : nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum)) {
                max = Math.max(max, i - map.get(sum));
            } else map.put(sum, i);
        }
        return max;
    }
}