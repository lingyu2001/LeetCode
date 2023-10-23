class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            // distinct the first number
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                while (j < nums.length && j != i + 1 && nums[j] == nums[j - 1]) {
                    j++;
                }
                while (k >= 0 && k + 1 < nums.length && nums[k] == nums[k + 1]) {
                    k--;
                }   
                if (j < k && nums[j] + nums[k] == -nums[i]) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[k]);
                    res.add(new ArrayList<>(list));
                    j++;
                    k--;
                } else if (j < k && nums[j] + nums[k] > -nums[i]){
                    k--;
                } else {
                    j++;
                }
            }
        }
        return res;
    }
}