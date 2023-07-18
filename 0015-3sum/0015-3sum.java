class Solution {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> current = new ArrayList<>();
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        // -4 -1 -1 0 1 2
        if (nums[0] > 0 || nums[nums.length - 1] < 0) return result;
        for (int i = 0; i < nums.length - 2; i++) {
            // distinct
            while (i > 0 && nums[i] == nums[i - 1]) {
                i++;
                if(i >= nums.length) {
                    return result;
                }
            }
            current.add(nums[i]);
            //a + b = -nums[i]
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                if (nums[left] + nums[right] == -nums[i]) {
                    current.add(nums[left]);
                    current.add(nums[right]);
                    result.add(new ArrayList<>(current));
                    current.clear();
                    current.add(nums[i]);
                    // distinct a 
                    while (left < right && nums[left] == nums[left + 1])  {
                        left++; 
                    }
                    // distinct b
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    left++;
                    right--;
                } else if (nums[left] + nums[right] < -nums[i]) {
                    left++;
                } else {
                    right--;
                }
            }
            current.clear();
        }
        return result;
    }
}