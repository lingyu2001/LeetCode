class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character,Integer> map = new HashMap<>();
        int left = 0, right = 0,res = 0;
        while (right < s.length()) {
            map.put(s.charAt(right), map.getOrDefault(s.charAt(right),0) + 1);
            int len = right - left + 1;
            int max = findMax(map);
            if (len - max <= k) {
                res = Math.max(res, len);
                right++;
            } else {
                map.put(s.charAt(left), map.get(s.charAt(left)) - 1);
                left++;
                right++;
            }
        }
        return res;
    }
    
    public int findMax(Map<Character, Integer> map) {
        int max = 0;
        for (int i : map.values()) {
            max = Math.max(i, max);
        }
        return max;
    }
}