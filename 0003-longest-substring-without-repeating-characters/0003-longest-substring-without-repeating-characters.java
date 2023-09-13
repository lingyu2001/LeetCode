class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max = 1;
        int left = 0, right = 0;
        if (s.length() <= 1) return s.length();
        Map<Character, Integer> map = new HashMap<>();
        while (right < s.length()) {
            char c = s.charAt(right);
            // System.out.println(s.substring(left, right + 1));
            if (map.containsKey(c)) {
                map.remove(s.charAt(left));
                left++;
            } else {
                map.put(c, right);
                // max = Math.max(max, right - left + 1);
                if (right - left + 1 > max) {
                    max = right - left + 1;
                    // System.out.println("max:" + s.substring(left, right + 1));  
                }
                right++;
            }
        }
        return max;
    }
}