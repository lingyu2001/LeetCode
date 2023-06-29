class Solution {
    public int removeElement(int[] nums, int val) {
        // int cnt = nums.length;
        int i = 0, j = nums.length - 1;
        while (i < j) {
            if (nums[i] == val && nums[j] != val) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
            // i points at positions with val value
            if (nums[i] != val) {
                i++;
            }
            // j points at positions with non val value
            if (nums[j] == val) {
                j--;
            }
        }
        // if (i == j && nums[i] == val) {
        //     return cnt - 1;
        // }
        int cnt = 0;
        for (int k = 0; k < nums.length; k++) {
            System.out.print(nums[k] +" ");
            if (nums[k] == val) {
                break;
            } else {
                cnt++;
            }
        }
        return cnt;
    }
}