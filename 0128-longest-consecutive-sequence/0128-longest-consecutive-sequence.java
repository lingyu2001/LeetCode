class Solution {
    public int longestConsecutive(int[] nums) {
        int max = 0;
        Set<Integer> set = new HashSet<>();
        for (int i : nums) {
            set.add(i);
        }
        for (int i : nums) {
            int cnt = 0;
            if (!set.contains(i + 1)) {
                int j = i;
                while (set.contains(j)) {
                    cnt++;
                    set.remove(j);
                    j--;
                }
            }
            max = Math.max(max, cnt);
        }
        return max;
    }
}