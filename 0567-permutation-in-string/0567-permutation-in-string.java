class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;
        // store s1 in hashMap
        Map<Character,Integer> map1 = new HashMap<>();
        for (char c : s1.toCharArray()) {
            map1.put(c, map1.getOrDefault(c,0) + 1);
        }
         // for (int i = 0; i < s1.length(); i++)
         //    map1.put(s1.charAt(i), map1.getOrDefault(s1.charAt(i), 0) + 1);
        for (int i = 0; i <= s2.length() - s1.length(); i++) {
            HashMap<Character, Integer> map2 = new HashMap<>();
            for(int j = 0; j < s1.length(); j++) {
                map2.put(s2.charAt(i + j), map2.getOrDefault(s2.charAt(i + j),0) + 1);
            }
            if (helper(map1,map2)) return true;
        }
        // System.out.println("2");
        return false;
    }
    
    public boolean helper( Map<Character,Integer> map1, Map<Character,Integer> map2) {
        for (char c: map1.keySet()) {
            if (!map1.get(c).equals(map2.getOrDefault(c,0))) return false;
        }
        return true;
    }
}