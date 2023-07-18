class Solution {
    public boolean checkInclusion(String s1, String s2) {
        // store s1 in hashMap
        Map<Character,Integer> map = new HashMap<>();
        for (char c : s1.toCharArray()) {
            map.put(c, map.getOrDefault(c,0) + 1);
        }
        int l = 0, r = s2.length() - 1;
        while (l <= r) {
            while (l < s2.length() && !map.containsKey(s2.charAt(l))) l++;
            while (r >= 0 && !map.containsKey(s2.charAt(r))) r--;
            // System.out.println(l + ":" + s2.charAt(l) + "," + r + ":" + s2.charAt(r));
            if (r - l + 1< s1.length()) return false;
            else {
                if (!helper(s2, l, l + s1.length() - 1, map)) {
                    l++;
                } else{
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean helper(String s2, int l, int r, Map<Character,Integer> map) {
        String s = s2.substring(l, r + 1);
        Map<Character,Integer> map1 = new HashMap<>();
        for (char c : s.toCharArray()) {
            map1.put(c, map1.getOrDefault(c,0) + 1);
        }
        for (char c: map.keySet()) {
            if (!map.get(c).equals(map1.getOrDefault(c,0))) return false;
        }
        return true;
    }
}