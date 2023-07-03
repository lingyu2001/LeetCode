class Solution {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> current = new ArrayList<>();
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        // determine i
        for (int i = 0; i < nums.length; i++) {
            // distinct i
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int left = i + 1, right = nums.length - 1; left < right; ) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    current.add(nums[i]);
                    current.add(nums[left]);
                    current.add(nums[right]);
                    result.add(new ArrayList<>(current));
                    current.clear();
                    left++;
                    right--;
                    // distinct b,c
                    while (left < nums.length && nums[left] == nums[left - 1]) left++;
                    while (right >= 0 && nums[right] == nums[right + 1]) right--;
                } else if (sum > 0) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        return result;
    }
}