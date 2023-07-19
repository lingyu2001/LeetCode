class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] strs = s.split(" ");
        Map<Character, String> map = new HashMap<>();
        // System.out.println(strs.length + " " + pattern.length());
        if (strs.length != pattern.length()) return false;
        for (int i = 0; i < pattern.length(); i++) {
            if (!map.containsKey(pattern.charAt(i))) {
                // System.out.println(map.values() + " " +strs[i] );
                if (map.values().contains(strs[i])) return false;
                map.put(pattern.charAt(i), strs[i]);
            } else {
                if (!map.get(pattern.charAt(i)).equals(strs[i])) {
                    // System.out.println(map.get(pattern.charAt(i)) + " " +strs[i] );
                    return false;
                }
            }
        }
        return true;
    }
}