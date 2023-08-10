class Solution {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] pre = new int[len];
        int[] post = new int[len];
        pre[0] = 1;
        post[len - 1] = 1;
        for (int i = 1; i < len; i++) {
            pre[i] = pre[i - 1] * nums[i - 1];
            post[len - i - 1] = post[len - i] * nums[len - i];
        }
        // post[len - 1] = 1;
        // for (int i = len - 2; i >= 0; i--) {
        //     post[i] = post[i + 1] * nums[i + 1];
        // }
        for (int i = 0; i < len; i++) {
            post[i] *= pre[i];
        }
        return post;
        
    }
}