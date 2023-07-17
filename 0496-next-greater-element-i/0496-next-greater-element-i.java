class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        // sol1: bf
        int[] ans = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            int index = -1, res = -1;
            for (int j = 0; j < nums2.length; j++) {
                if (nums2[j] == nums1[i]) {
                    index = j;
                }
                if (index != -1) {
                    if (nums2[j] > nums2[index]) {
                        res = nums2[j];
                        ans[i] = res;
                        break;
                    }
                }
                if (j == nums2.length - 1 && res == -1) ans[i] = -1;
            }
        }
        return ans;
    }
}