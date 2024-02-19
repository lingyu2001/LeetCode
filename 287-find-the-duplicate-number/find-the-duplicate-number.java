class Solution {
    public int findDuplicate(int[] nums) {
        // find the beginning of the cycle
        int p1 = 0, p2 = 0;
        int meet = 0;
        while (true) {
            int idx1 = nums[p1]; // where p1 goes to
            int idx2 = nums[p2]; // where p2 first goes to 
            idx2 = nums[idx2]; // where p2 finally goes to
            if (idx1 == idx2) {
                meet = idx1;
                break;
            }
            p1 = idx1;
            p2 = idx2;
        }
        p1 = 0;
        p2 = meet;
        // Phase 2: Finding the "entrance" to the cycle.
        while (p1 != p2) {
            p1 = nums[p1];
            p2 = nums[p2];
        }
        return p1;
    }
}