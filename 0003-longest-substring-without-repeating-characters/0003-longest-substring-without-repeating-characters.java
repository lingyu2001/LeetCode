class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() < 2) return s.length();
        Set<Character> set = new HashSet<>();
        int l = 0, r = 1;
        int max = 0;
        set.add(s.charAt(l));
        while (r < s.length()) {
            if (set.contains(s.charAt(r))) {
                set.remove(s.charAt(l));
                l++;
            } else {
                set.add(s.charAt(r));
                max = Math.max(max, s.substring(l, r + 1).length());
                r++;
            }
        }
        return max;
    }
}