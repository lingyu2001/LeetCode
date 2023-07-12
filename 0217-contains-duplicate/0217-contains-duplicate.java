class Solution {
    public boolean containsDuplicate(int[] nums) {
        // iterate each element in nums
            //  if ele is already in the set
                    // return true
            // add the ele to the set
        // end iteration
        // return false;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                return true;
            }
            set.add(nums[i]);
        }
        return false;
    }
}