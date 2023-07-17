class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        Arrays.sort(nums);
        List<Integer> res = new ArrayList<>();
        int index = 1,size = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == index) {
                index++;
            } else {
                if (nums[i] < index) continue;
                else if (nums[i] > index) {
                    res.add(index);
                    index++;
                    i--;
                }
            }
        }
        for (int i = index; i <= nums.length; i++) {
            res.add(i);
        }
        return res;
    }
}