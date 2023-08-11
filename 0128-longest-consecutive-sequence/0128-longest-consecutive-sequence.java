class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        for (int i = 0; i < nums.length; i++) {
            int cnt = 0;
            if (!set.contains(nums[i] - 1)) {
                int j = nums[i];
                while (set.contains(j)) {
                    cnt++;
                    set.remove(j);
                    j++;
                }
                max = Math.max(max, cnt);
            }
        }
        return max;
    }
}