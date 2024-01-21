class Solution {
    public int longestConsecutive(int[] nums) {
        // add all elements to the hashset
        HashSet<Integer> set = new HashSet<>();
        for (int n : nums) set.add(n);
        // iterate each element in the array
        // if it is the smallest element in the consecutive elements sequence?
        // => yes. find the length of the sequence, compare the len to the current res variable
        int res = 0;
        // => no. continue;
        for (int n : nums) {
            if (set.contains(n - 1)) continue;
            int j = n;
            while (set.contains(j)) {
                j++;
            }
            res = Math.max(res, j - n);
        }
        // return res;
        return res;
    }
}