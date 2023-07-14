class Solution {
    public int lengthOfLastWord(String s) {
        s = s.trim();
        StringBuilder sb = new StringBuilder(s);
        int res = 0;
        for (int i = sb.length() - 1; i >= 0; i--) {
            if (sb.charAt(i) != ' ') res++;
            else 
                return res;
        }
        return res;
    }
}