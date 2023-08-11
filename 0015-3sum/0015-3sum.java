class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            // make a distinct
            while (i - 1 >= 0 && i < nums.length - 2 && nums[i - 1] == nums[i]) i++;
            int target = -nums[i];
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                if (target == nums[left] + nums[right]) {
                    ArrayList<Integer> arr = new ArrayList<>();
                    arr.add(nums[i]);
                    arr.add(nums[left]);
                    arr.add(nums[right]);
                    res.add(arr);
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;
                    left++;
                    right--;
                } else if (target < nums[left] + nums[right]) {
                    right--;
                } else left++;
            }
        }
        return res;
    }
}