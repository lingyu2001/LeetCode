class Solution {
    public int characterReplacement(String s, int k) {
        // # of the most frequent word >= len of the window - k
        int le = 0, ri = 1;
        int res = 1;
        HashMap<Character, Integer> map = new HashMap<>();
        map.put(s.charAt(0),1);
        while (ri < s.length()) {
            map.put(s.charAt(ri), map.getOrDefault(s.charAt(ri), 0) + 1);
            // calculate the window
            int winLen = ri - le + 1;
            // calculate the highest value in the map
            int max = 0;
            for (int v : map.values()) {
                max = Math.max(max, v);
            }
            if (max >= winLen - k) res = Math.max(res, winLen);
            else {
                map.put(s.charAt(le), map.get(s.charAt(le)) - 1);
                le++;
            }
            ri++;
        }
        return res;
    }
}