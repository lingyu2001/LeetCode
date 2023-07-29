class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        int[] prefix = new int[nums.length];
        int[] postfix = new int[nums.length];
        prefix[0] = nums[0];
        postfix[nums.length - 1] = nums[nums.length - 1];
        for (int i = 1; i < nums.length; i++) {
            if (i - 1 >= 0) {
                prefix[i] = prefix[i - 1] * nums[i]; 
            }
        }
        
        // for(int i:prefix) {
        //     System.out.print(i + " ");
        // }
        // System.out.println();
        
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i + 1 < nums.length) {
                postfix[i] = nums[i] * postfix[i + 1];
            }
        }
        // for(int i:postfix) {
        //     System.out.print(i + " ");
        // }
        // System.out.println();
        
        for (int i = 0; i < nums.length; i++) {
            res[i] = 1;
        }
        
        for (int i = 0; i < res.length; i++) {
            if (i - 1 >= 0) 
                res[i] *= prefix[i - 1];
            if (i + 1 < nums.length) {
                res[i] *= postfix[i + 1];
            }
        }
        return res;
    }
}