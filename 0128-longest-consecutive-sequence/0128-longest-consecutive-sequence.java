class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int res = 0;
        for (int i : nums) {
            set.add(i);
        }
        for (int i : nums) {
            if (!set.contains(i + 1)) {
                int cnt = 0;
                int j = i;
                while (set.contains(j)) {
                    cnt++;
                    set.remove(j);
                    j--;
                }
                res = Math.max(res, cnt);
            }
        }
        return res;
    }
}