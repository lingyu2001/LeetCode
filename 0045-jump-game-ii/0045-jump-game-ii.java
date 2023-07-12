class Solution {
    public int jump(int[] nums) {
        if (nums.length == 1) return 0;
        int cnt = 0;
        int currDis = 0, nextDis = 0;
        for (int i = 0; i < nums.length; i++) {
            nextDis = Math.max(nextDis, i + nums[i]);
            if (i == currDis) {
                cnt++;
                currDis = nextDis;
                if (nextDis >= nums.length - 1) break;
            }
            
        }
        return cnt;
    }
}