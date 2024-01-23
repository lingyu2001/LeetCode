class Solution {
    public int lengthOfLongestSubstring(String s) {
        // while right pointer is < s.length
        // if the window has no repeating characters => compare the size of the window to the res;
        // else => move the window => how? make the window smaller until there is no repeating char in the window
        HashSet<Character> set = new HashSet<>();
        int lo = 0, ri = 0;
        int res = 0;
        while (ri < s.length()) {
            if (set.add(s.charAt(ri))) {
                res = Math.max(res, ri - lo + 1);
            } else {
                while (!set.add(s.charAt(ri))) {
                    set.remove(s.charAt(lo));
                    lo++;
                }
            }
            ri++;
        }
        return res;
    }
}