class Solution {
    public int lengthOfLongestSubstring(String s) {
        int len = 1;
        int le = 0, ri = 1;
        Set<Character> set = new HashSet<>();
        if(s.length() < 2) return s.length();
        set.add(s.charAt(0));
        while (ri < s.length() && le <= ri) {
            if (set.add(s.charAt(ri))) {
                len = Math.max(ri - le + 1, len);
                ri++;
            } else {
                // remove chars so that theres no duplicate chars in the window
                while (!set.add(s.charAt(ri))) {
                    set.remove(s.charAt(le));
                    le++;
                }
                ri++;
            }
        }
        return len;
    }
}