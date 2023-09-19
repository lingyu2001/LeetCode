class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if (s.length() < p.length()) return res;
        int[] a = new int[26];
        int[] b = new int[26];
        for (int i = 0; i < p.length(); i++) {
            a[s.charAt(i) - 'a']++;
            b[p.charAt(i) - 'a']++;
        }
        if (areEqual(a,b)) res.add(0);

        for (int i = p.length(); i < s.length(); i++){
            a[s.charAt(i - p.length()) - 'a']--;
            a[s.charAt(i) - 'a']++;
            if (areEqual(a,b)) res.add(i - p.length() + 1);
        }
        return res;
    }

    public boolean areEqual(int[] a, int[]b) {
        for (int i = 0; i < 26; i++) {
            if (a[i] != b[i]) return false;
        }
        return true;
    }
}