class Solution {
    public boolean isAnagram(String s, String t) {
        // check if len(s) == len(t), no--> return false
        int len1 = s.length();
        int len2 = t.length();
        if (len1 != len2) return false;
        // store s in the set
        int[] chars = new int[26];
        for (int i = 0; i < len1; i++) {
            chars[s.charAt(i) - 'a']++;
        }
        // check t
        // iterate each char c in t
        for (int i = 0; i < len2; i++) {
            chars[t.charAt(i) - 'a']--;
            if (chars[t.charAt(i) - 'a'] < 0) return false;
        }
        return true;
        // if the number of c in the set < 0, then return false;

    }
}