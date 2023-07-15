class Solution {
    public int removeElement(int[] nums, int val) {
        int p1 = 0, index = 0;
        while (p1 < nums.length) {
            if(nums[p1] != val) {
                nums[index++] = nums[p1++];
            }else{
                p1++;
            }
        }
        return index;
    }
}