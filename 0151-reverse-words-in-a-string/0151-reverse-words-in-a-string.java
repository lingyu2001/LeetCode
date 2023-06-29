class Solution {
    public String reverseWords(String s) {
        // remove the space at the beginning and the end of the string
        s = s.trim();
        // remove the space in the string
        StringBuilder sb = new StringBuilder();
        sb = removeString(s);
        // reverse the String
        reverseString(sb, 0, sb.length() - 1);
        // reverse each word
        reverseEachWord(sb);
        return String.valueOf(sb);
    }
    
    private StringBuilder removeString(String s) {
        int i = 0, j = s.length();
        StringBuilder sb = new StringBuilder();
        while (i < j) {
            // get the character at index i
            char c = s.charAt(i);
            // remove continuous spaces, the second condition is to prevent sb from having continuous spaces
            if (c != ' ' || sb.charAt(sb.length() - 1) != ' ') {
                sb.append(c);
            }
            i++;
        }
        return sb;
    }
    
    private void reverseString(StringBuilder sb, int start, int end) {
        for(int i = start, j = end; i <= j; i++, j--) {
            char temp = sb.charAt(i);
            sb.setCharAt(i, sb.charAt(j));
            sb.setCharAt(j, temp);
        }
    }
    
    private void reverseEachWord(StringBuilder sb) {
        int i = 0, j = sb.length();
        while (i < j) {
            int end = i;
            while (end < j && sb.charAt(end) != ' ') {
                end++;
            }
            reverseString(sb, i, end - 1);
            i = end + 1;
        }
    }
}