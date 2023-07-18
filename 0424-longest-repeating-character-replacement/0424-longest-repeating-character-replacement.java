class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        int l = 0, r = 0, max = 0;
        map.put(s.charAt(0),1);
        while (r < s.length()) {
            int len = r - l + 1;
            int maxCnt = findMax(map);
            if (len - maxCnt <= k) {
                r++;
                if (r < s.length()) 
                    map.put(s.charAt(r),map.getOrDefault(s.charAt(r),0)+1);
                if (len > max) {
                    max = len;
                    // System.out.println(l + " " + r);
                }
            } else {
                map.put(s.charAt(l),map.get(s.charAt(l)) - 1);
                l++;
            }
        }
        return max;
    }
    
    public int findMax(Map<Character, Integer> map) {
        int max = 0;
        for (int i: map.values()) {
            max = Math.max(i,max);
        }
        // System.out.println(map.values());
        return max;
    }
}