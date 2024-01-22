class Solution {
    public boolean checkInclusion(String s1, String s2) {
        char[] cnt = new char[26];
        for (char c : s1.toCharArray()) {
            cnt[c - 'a']++;
        }
        int le = 0, hi = 0;
        char[] window = new char[26];
        while (hi < s2.length()) {
            window[s2.charAt(hi) - 'a']++;
            int winLen = hi - le + 1;
            if (winLen < s1.length()) {
                hi++;
            } else if (winLen == s1.length()) {
                if (String.valueOf(cnt).equals(String.valueOf(window))) return true;
                window[s2.charAt(le) - 'a']--;
                le++;
                hi++;
            }
        }
        return false;
    }
}