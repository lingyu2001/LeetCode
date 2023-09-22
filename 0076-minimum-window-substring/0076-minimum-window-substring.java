class Solution {
    public String minWindow(String s, String t) {
        int[] cntS = new int[256];
        int[] cntT = new int[256];
        int K = 0;
        int now = 0;
        int l = 0, r = 0;
        int ansLeft = -1, ansRight = -1;
        for (char c : t.toCharArray()) {
            cntT[c]++;
            if (cntT[c] == 1) K++;
        }
        for (l = 0; l < s.length(); l++) {
            while (r < s.length() && now < K) {
                cntS[s.charAt(r)]++;
                if (cntS[s.charAt(r)] == cntT[s.charAt(r)]) now++;
                r++;
            }
            if (K == now) {
                if (ansLeft == -1 || r - l < ansRight - ansLeft) {
                    ansLeft = l;
                    ansRight = r;
                }
            }
            //move pointer l
            cntS[s.charAt(l)]--;
            if (cntS[s.charAt(l)] < cntT[s.charAt(l)]) now--;
        }
        if (ansLeft == -1) return "";
        else return s.substring(ansLeft, ansRight);
    }
}