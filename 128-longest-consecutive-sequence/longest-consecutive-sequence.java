class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        // add all elements in the hashtable
        int res = 0;
        for (int i : nums) set.add(i);
        for (int i : nums) {
            // if i is the smallest number in the consecutive elements sequence
            if (set.contains(i - 1)) {
                continue;
            }
            int len = 1;
            int j = i + 1;
            while (set.contains(j)) {
                len++;
                j++;
            }
            res = Math.max(len, res);
        }
        return res;
    }
}