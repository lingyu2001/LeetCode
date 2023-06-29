class Solution {
    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> list = new LinkedList<>();
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int i = 0, left, right;
		// 对a去重
        for(i = 0; i < nums.length; i++) {
            if (nums[i] > 0) 
                return result;
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for(left = i + 1, right = nums.length - 1;left < right;) {
                int sum = nums[i] + nums[left] + nums[right];
                if(sum == 0) {
                    list.add(nums[i]);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    result.add(new ArrayList<>(list));
                    list.clear();
                    left++;
										// 对b和c去重
                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }
                    right--;
                    while (left < right && right + 1 < nums.length && nums[right] == nums[right + 1]) {
                        right--;
                    }
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return result;
    }
}