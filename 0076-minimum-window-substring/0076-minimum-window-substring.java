class Solution {
    public String minWindow(String s, String t) {
        // corner case : len(s) < len(t) => return false
        // construct the window: int[] array [a,b)
        // move the window
        // pointers: left, right
        // valid: # of valid letters in the window
        int left = 0, right = 0;
        int[] tArr = new int[256];
        HashSet<Character> set = new HashSet<>();
        for (char c : t.toCharArray()) {
            set.add(c);
            tArr[c]++;
        }
        int[] sArr = new int[256];
        int valid = 0;
        String res = "";
        int len = Integer.MAX_VALUE;
        while (right < s.length()) {
            char r = s.charAt(right);
            right++;
            if (tArr[r] > 0) {
                sArr[r]++;
                if (tArr[r] == sArr[r]) valid++;
            }
            while (valid == set.size()) {
                if (right - left < len) {
                    res = s.substring(left, right);
                    len = right - left;
                }
                char l = s.charAt(left);
                left++;
                if (tArr[l] > 0) {
                    sArr[l]--;
                    if (sArr[l] < tArr[l]) valid--;
                }
            }
        }
        return res;
    }
}