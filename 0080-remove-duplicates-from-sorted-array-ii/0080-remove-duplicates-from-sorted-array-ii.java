class Solution {
    public int removeDuplicates(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int s = 0, f = 0;
        while (f < nums.length) {
            int cnt = map.getOrDefault(nums[f], 0);
            if (cnt >= 2) {
                f++;
            } else {
                map.put(nums[f], cnt + 1);
                nums[s] = nums[f];
                s++;
                f++;
            }
        }
        return s;
    }
}