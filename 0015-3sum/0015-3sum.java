class Solution {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new LinkedList<>();
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        if (nums[0] > 0 || nums[nums.length - 1] < 0) return res;
        for (int i = 0; i < nums.length - 2; i++) {
            //  distinct 1
            if(i >= 1 && nums[i] == nums[i - 1]) continue;
            int target = -nums[i];
            int j = i + 1, k = nums.length - 1;
            while (j < k) {
                if (nums[j] + nums[k] == target) {
                    path.add(nums[i]);
                    path.add(nums[j]);
                    path.add(nums[k]);
                    res.add(new ArrayList<>(path));
                    path.clear();
                    j++;
                    k--;
                    while (j < nums.length && nums[j] == nums[j - 1]) j++;
                    while (k >= 0 && nums[k + 1] == nums[k]) k--;
                }
                else if (nums[j] + nums[k] > target) {
                    k--;
                } else j++;
            }
        }
        return res;
    }
}