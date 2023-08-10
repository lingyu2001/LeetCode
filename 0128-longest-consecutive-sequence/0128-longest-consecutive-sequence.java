class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (!set.contains(nums[i] - 1)) {
                int cnt = 1;
                int j = nums[i] + 1;
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