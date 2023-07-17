class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length <= 2) return nums.length;
        int i = 2, j = 2, cnt = 0;
        if (nums[0] == nums[1]) cnt = 2;
        else cnt = 1;
        while (j < nums.length) {
            if (nums[j] == nums[j - 1]) {
                cnt++;
                if (cnt > 2) {
                    j++;
                } else{
                    nums[i++] = nums[j++];
                }
                
            } else{
                nums[i++] = nums[j++];
                cnt = 1;
            }
        }
        return i;
    }
}