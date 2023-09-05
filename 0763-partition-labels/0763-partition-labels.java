class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> res = new ArrayList<>();
        int[] arr = new int[26];
        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i) - 'a'] = i;
        }
        int i = 0, j = 0;
        while (i < s.length()) {
            j = Math.max(j, arr[s.charAt(i) - 'a']);
            int cnt = 0;
            while (i <= j) {
                j = Math.max(j, arr[s.charAt(i) - 'a']);
                i++;
                cnt++;
            }
            res.add(cnt);
        }
        return res;
    }
}