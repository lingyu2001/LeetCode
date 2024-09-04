class Solution {
    public int removeDuplicates(int[] nums) {
        int location = 0, iterator = 0;
        HashSet<Integer> hash = new HashSet();
        while (iterator < nums.length) {
            if (hash.add(nums[iterator])) {
                nums[location++] = nums[iterator];
            }
            iterator++;
        }
        return location;
    }
}