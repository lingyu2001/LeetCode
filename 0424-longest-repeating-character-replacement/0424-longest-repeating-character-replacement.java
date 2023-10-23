class Solution {
    public int characterReplacement(String s, int k) {
        // # of the most frequent character >= len - k
        // => yes, right++;
        // => no, left++;
        int l = 0, r = 0;
        int max = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        while (r < s.length()) {
            char c = s.charAt(r);
            map.put(c, map.getOrDefault(c, 0) + 1);
            int m = findMax(map);
            if (m < r - l + 1 - k) {
                map.put(s.charAt(l), map.get(s.charAt(l)) - 1);
                l++;
                r++;
            } else {
                max = Math.max(max, r - l + 1);
                r++;
            }
        }
        return max;
    }

    public int findMax(HashMap<Character, Integer> map) {
        int max = 0;
        for (int v : map.values()) {
            max = Math.max(max, v);
        }
        return max;
    }
}