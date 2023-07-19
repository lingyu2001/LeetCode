class Solution {
    public int[] sortArray(int[] nums) {
        return helper(nums,0,nums.length - 1);
        
    }
    
    public int[] helper(int[] nums, int left, int right) {
        if (left == right) return new int[]{nums[left]};
        else if (left == right - 1) {
            return new int[]{Math.min(nums[left],nums[right]),Math.max(nums[left],nums[right])};
        } else if (left > right) {
            return null;
        }
        int mid = left + (right - left) / 2;
        int[] res1 = helper(nums,left,mid);
        int[] res2 = helper(nums, mid + 1, right);
        int i = 0, j = 0, index = 0;
        int[] res = new int[res1.length + res2.length];
        while (i < res1.length && j < res2.length) {
            if (res1[i] < res2[j]) {
                res[index++] = res1[i++];
            } else{
                res[index++] = res2[j++];
            }
        } 
        while (i < res1.length) {
            res[index++] = res1[i++];
        }
        while (j < res2.length) {
            res[index++] = res2[j++];
        }
        return res;
    }
}