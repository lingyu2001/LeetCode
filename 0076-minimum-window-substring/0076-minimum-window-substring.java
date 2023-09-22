class Solution {
    public String minWindow(String s, String t) {
        // sliding window
        // two pointer : left, right;
        // how to move the sliding window?
        //      keep moveing pointer right, until # of each character in the window is >= # of each character in t
        //          how to calculate that? : int[] cntS, int[] cntT
        //      then calculate the min window
        //      then move pointer left
        int[] cntS = new int[256];
        int[] cntT = new int[256];
        int now = 0, k = 0;
        int r = 0, l = 0, minL = -1, minR = -1;
        for (char c : t.toCharArray()) {
            cntT[c]++;
            if (cntT[c] == 1) k++;
        }
        for (; l < s.length(); l++) {
            while (r < s.length() && now < k) {
                cntS[s.charAt(r)]++;
                if (cntS[s.charAt(r)] == cntT[s.charAt(r)]) now++;
                r++;
            }
            if (now == k) {
                if (minL == -1 || r - l < minR - minL) {
                    minL = l;
                    minR = r;
                }
            }
            cntS[s.charAt(l)]--;
            if (cntS[s.charAt(l)] < cntT[s.charAt(l)]) now--;
        }
        return minL == -1 ? "" : s.substring(minL, minR);
    }
}