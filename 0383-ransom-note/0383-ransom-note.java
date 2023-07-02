class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] ints = new int[26];
        for (int i = 0; i < magazine.length(); i++) {
            ints[magazine.charAt(i) - 'a']++;
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            if (ints[ransomNote.charAt(i) - 'a'] <= 0)
                return false;
            else {
                ints[ransomNote.charAt(i) - 'a']--;
            }
        }
        return true;
    }
}