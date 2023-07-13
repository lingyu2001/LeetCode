class Solution {
    public int characterReplacement(String s, int k) {
        int l = 0, r = 0;
        int res = 0;
        int max = 0;
        int[] cnt = new int[26];
        while (r < s.length()) {
            cnt[s.charAt(r) - 'A']++;
            max = maxMethod(cnt);
            if (r - l + 1 - max > k) {
                cnt[s.charAt(l) - 'A']--;
                l++;
            } else {
                res = Math.max(res, r - l + 1);
            }
            r++;
        }
        return res;
    }
    
    public int maxMethod(int[] cnt) {
        int max = 0;
        for (int i = 0; i < cnt.length; i++) {
            max = Math.max(max, cnt[i]);
        }
        return max;
    }
}