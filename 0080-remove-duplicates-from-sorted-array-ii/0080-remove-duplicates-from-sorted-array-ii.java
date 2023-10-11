class Solution {
    // public int removeDuplicates(int[] nums) {
    //     HashMap<Integer, Integer> map = new HashMap<>();
    //     int s = 0, f = 0;
    //     while (f < nums.length) {
    //         int cnt = map.getOrDefault(nums[f], 0);
    //         if (cnt >= 2) {
    //             f++;
    //         } else {
    //             map.put(nums[f], cnt + 1);
    //             nums[s] = nums[f];
    //             s++;
    //             f++;
    //         }
    //     }
    //     return s;
    // }

    public int removeDuplicates(int[] nums) {
        int s = 0, f = 0;
        int cnt = 0;
        while (f < nums.length) {
            if (nums[s] != nums[f]) {
                s++;
                nums[s] = nums[f];
            } else if (s < f && cnt < 2) {
                s++;
                nums[s] = nums[f];
            }
            f++;
            cnt++;
            if (f < nums.length && nums[f] != nums[f - 1]) cnt = 0;
        }
        return s + 1;
    }
}