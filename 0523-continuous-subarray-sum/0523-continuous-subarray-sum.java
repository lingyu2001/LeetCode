class Solution {
    Map<Integer, Integer> map = new HashMap<>();
    public boolean checkSubarraySum(int[] nums, int k) {
        map.put(0, -1);
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            sum = sum % k;
            Integer index = map.get(sum);
            if (index != null) {
                 if (i - index > 1) return true;
            } else map.put(sum, i);
        }
        return false;
    }
}