class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        if (nums[0] > 0 || nums[nums.length - 1] < 0) return res;
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {  // 去重a
                continue;
            }
            int target = -nums[i];
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                if (nums[left] + nums[right] == target) {
                    ArrayList<Integer> arr = new ArrayList<>();
                    arr.add(nums[i]);
                    arr.add(nums[left]);
                    arr.add(nums[right]);
                    res.add(arr);
                    // 对b，c去重
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;
                    left++;
                    right--;
                } else if (nums[left] + nums[right] < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return res;
    }
}