class Solution {
    public int lengthOfLongestSubstring(String s) {
        // two pointers, l, r
        // when to move the window
        // 
        Set<Character> set = new HashSet<>();
        int l = 0, r = 0;
        int max = 0;
        while (r < s.length()) {
            char c = s.charAt(r);
            if (!set.contains(c)) {
                set.add(c);
                max = Math.max(max, set.size());
                r++;
            } else {
                set.remove(s.charAt(l));
                l++;
            }
        }
        return max;
    }
}