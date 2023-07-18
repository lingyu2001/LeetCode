class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int max = 0;
        int l = 0, r = 0;
        while (r < s.length()) {
            if (!map.containsKey(s.charAt(r))) {
                map.put(s.charAt(r),r);
                if (map.size() > max) {
                    max = map.size();
                }
                r++;
            } else {
                map.remove(s.charAt(l));
                l++;
            }
        }
        return max;
    }
}