class SparseVector {
    int[] nums;
    int length ;
    SparseVector(int[] nums) {
        this.nums = nums;
        this.length = nums.length;
    }
    
	// Return the dotProduct of two sparse vectors
    public int dotProduct(SparseVector vec) {
        int ans = 0;
        for (int i = 0; i < vec.length; i++) {
            if (nums[i] == 0 || vec.nums[i] == 0) {
                continue;
            }
            else {
                ans += nums[i] * vec.nums[i];
            }
        }
        return ans;
    }
}

// Your SparseVector object will be instantiated and called as such:
// SparseVector v1 = new SparseVector(nums1);
// SparseVector v2 = new SparseVector(nums2);
// int ans = v1.dotProduct(v2);