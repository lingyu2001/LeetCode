class Solution {
    public String longestCommonPrefix(String[] strs) {
        int p = 0;
        boolean flag = false;
        while (true) {
            char c = ' ';
            if (p < strs[0].length()) {
                c = strs[0].charAt(p);
            } else {
                return strs[0].substring(0, p);
            }
            for (int i = 1; i < strs.length; i++) {
                if (p >= strs[i].length() ||  strs[i].charAt(p) != c) {
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                p++;
            } else {
                return strs[0].substring(0, p);
            }
        }
    }
}