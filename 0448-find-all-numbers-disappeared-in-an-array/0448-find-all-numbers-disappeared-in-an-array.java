class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int correctIndex = nums[i] - 1;
            if (nums[i] != nums[correctIndex]) {
                int t = nums[i];
                nums[i] = nums[correctIndex];
                nums[correctIndex] = t; 
                i--;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) res.add(i + 1);
        }
        return res;
    }
}