class Solution {
    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
         for (int i = 0; i < nums.length; i++) {
             if (i > 0 && nums[i] == nums[i - 1]) continue;
             for (int j = i + 1; j < nums.length; j++) {
                 if (j > i + 1 && nums[j] == nums[j - 1]) continue;
                 for(int left = j + 1, right = nums.length - 1; left < right;) {
                     long sum = (long)nums[i] + (long)nums[j] + (long)nums[left] + (long)nums[right];
                     if (sum == target) {
                        path.add(nums[i]);
                        path.add(nums[j]);
                        path.add(nums[left]);
                        path.add(nums[right]);
                        result.add(new ArrayList<>(path));
                        path.clear();
                        left++;
                        right--;
                        while (left < nums.length && nums[left] == nums[left - 1]) left++;
                        while (right >= 0 && nums[right + 1] == nums[right]) right--;
                     } else if (sum > target) {
                         right--;
                     } else {
                         left++;
                     }
                 }
             }
         }
        return result;
    }
}