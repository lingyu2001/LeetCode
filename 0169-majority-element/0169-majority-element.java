class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int bottomLine = nums.length / 2;
        for (int i = 0; i < nums.length; i++) {
            Integer cnt = map.getOrDefault(nums[i],0) + 1;
            if (cnt > bottomLine) return nums[i];
            map.put(nums[i], cnt);
        }
        return 0;
    }
}