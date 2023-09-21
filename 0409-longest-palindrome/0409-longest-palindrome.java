class Solution {
    public int longestPalindrome(String s) {
        Map<Character,Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        boolean flag = false;
        int res = 0;
        for (int i : map.values()) {
            if (i % 2 == 0) res += i;
            else if (flag) res += (i - 1);
            else if (!flag){
                res += i;
                flag = true;
            }
        }
        return res;
    }
}