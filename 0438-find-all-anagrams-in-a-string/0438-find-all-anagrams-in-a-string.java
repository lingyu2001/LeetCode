class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        int[] pArr = new int[256];
        int[] sArr = new int[256];
        int left = 0, right = 0, valid = 0;
        HashSet<Character> set = new HashSet<>();
        for (char c : p.toCharArray()) {
            pArr[c]++;
            set.add(c);
        }
        while (right < s.length()) {
            char r = s.charAt(right);
            right++;
            if (set.contains(r)) {
                sArr[r]++;
                if (sArr[r] == pArr[r]) valid++;
            }

            while (valid == set.size()) {
                char l = s.charAt(left);
                if (right - left == p.length()) res.add(left);
                left++;
                if (set.contains(l)) {
                    sArr[l]--;
                    if (sArr[l] < pArr[l]) valid--;
                }
            }
        }
        return res;
    }
}