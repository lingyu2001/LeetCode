class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> res = new ArrayList<>();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), i);
        }
        int i = 0, j = 0;
        while (i < s.length()) {
            int cnt = 0;
            j = map.get(s.charAt(i));
            while (i <= j) {
                cnt++;
                j = Math.max(j, map.get(s.charAt(i)));
                i++;
            }
            res.add(cnt);
        }
        return res;
    }
}