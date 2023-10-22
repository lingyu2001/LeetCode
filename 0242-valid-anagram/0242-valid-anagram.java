class Solution {
    public boolean isAnagram(String s, String t) {
        int[] arr = new int[256];
        if (s.length() != t.length()) return false;
        // keep track on the number of characters in s
        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i)]++;
        }
        for (int i = 0; i < t.length(); i++) {
            arr[t.charAt(i)]--;
            if (arr[t.charAt(i)] < 0) return false;
        }
        return true;
    }
}