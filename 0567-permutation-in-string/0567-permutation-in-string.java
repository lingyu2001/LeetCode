class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n = s1.length(), m = s2.length();
        int[] f = new int[26];
        for (int i = 0; i < n; i++) {
            f[s1.charAt(i) - 'a']++;
        }
        int[] freq = new int[26];
        for (int i = 0; i < m; i++) {
            freq[s2.charAt(i) - 'a']++;
            if (i >= n) {
                freq[s2.charAt(i - n) - 'a']--;
            }
            if (Arrays.equals(f,freq)) return true;
        }
        return false;
    }
}