class Solution {
    StringBuilder sb;
    public String reverseWords(String s) {
        s = s.trim();
        sb = removeSpaceInside(s);
        reverse(sb, 0, sb.length() - 1);
        reserseEachWord(sb);
        return String.valueOf(sb);
    }

    public StringBuilder removeSpaceInside(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (i > 0 && s.charAt(i - 1) == ' ' && s.charAt(i) == ' ') {
                continue;
            } else {
                sb.append(s.charAt(i));
            }
        }
        return sb;
    }
    
    public void reverse(StringBuilder s, int start, int end) {
        for (int i = start, j = end; i < j; i++, j--) {
            char temp = s.charAt(i);
            s.setCharAt(i,s.charAt(j));
            s.setCharAt(j, temp);
        }
    }
    
    public void reserseEachWord(StringBuilder sb) {
        int i,j;
        for (i = 0, j = i + 1; j < sb.length(); j++) {
            if (sb.charAt(j) == ' ') {
                reverse(sb, i, j - 1);
                i = j + 1;
            }
        }
        reverse(sb, i, sb.length()-1);
    }
}