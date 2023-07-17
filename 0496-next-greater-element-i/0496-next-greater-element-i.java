class Solution {
    public int[] nextGreaterElement1(int[] nums1, int[] nums2) {
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
    
    // sol2
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] ans = new int[nums1.length];
        for (int i = 0; i < ans.length; i++) ans[i] = -1; 
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            map.put(nums1[i],i);
        }
        Stack<Integer> s = new Stack<>();
        for (int i = 0; i < nums2.length; i++) {
            while (!s.isEmpty() && nums2[i] > s.peek()) {
                ans[map.get(s.pop())] = nums2[i];
            }
            if (map.containsKey(nums2[i])) s.push(nums2[i]);
        }
        return ans;
    }
}