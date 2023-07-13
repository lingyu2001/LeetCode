class Solution {
    // solution1
    public boolean isAnagram1(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] ints = new int[26];
        for (int i = 0; i < s.length(); i++) {
            ints[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            ints[t.charAt(i) - 'a']--;
            if (ints[t.charAt(i) - 'a'] < 0) return false;
        }
        return true;
    }
    
    // solution2
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        char[] s1 = s.toCharArray();
        char[] t1 = t.toCharArray();
        Arrays.sort(s1);
        Arrays.sort(t1);
        for (int i = 0; i < s.length(); i++) {
            if (s1[i] != t1[i]) return false;
        }
        return true;
    }
}