class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        return nSum(nums, 3, 0, 0);
    }

    public List<List<Integer>> nSum (int[] nums, int n, int start, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (n < 2 || nums.length < n) return res;
        if (n == 2) {
            int lo = start, hi = nums.length - 1;
            while (lo < hi) {
                if (nums[lo] + nums[hi] == target) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[lo]);
                    list.add(nums[hi]);
                    res.add(list);
                    lo++;
                    hi--;
                    while (lo < nums.length && nums[lo] == nums[lo - 1]) lo++;
                    while (hi >= 0 && nums[hi] == nums[hi + 1]) hi--;
                } else if (nums[lo] + nums[hi] < target) {
                    lo++;
                } else {
                    hi--;
                }
            }
        } else {
            for (int i = start; i < nums.length; i++) {
                if (i > 0 &&nums[i] == nums[i - 1]) continue;
                List<List<Integer>> subSum = nSum(nums, n - 1, i + 1, target - nums[i]);
                for (List<Integer> list : subSum) {
                    list.add(nums[i]);
                    res.add(list);
                }
            }
        }
        return res;
    }
}