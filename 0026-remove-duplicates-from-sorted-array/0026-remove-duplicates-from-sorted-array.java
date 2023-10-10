class Solution {
    public int removeDuplicates(int[] nums) {
        int s = 0, f = 0;
        HashSet<Integer> set = new HashSet<>();
        for (;f < nums.length; f++){
            if (set.add(nums[f])){
                nums[s] = nums[f];
                s++;
            }
        }
        return s;
    }
}