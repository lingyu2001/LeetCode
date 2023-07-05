class Solution {
    char[] chars;

    public String reverseStr(String s, int k) {
        chars = s.toCharArray();
        for (int i = 0; i < chars.length; i += 2 * k) {
            if (i + k - 1 < chars.length) {
                reverse(i, i + k - 1);
            } else {
                reverse(i, chars.length - 1);
            }
        }
        return String.valueOf(chars);
    }

    public void reverse(int start, int end) {
        for (int i = start, j = end; i < j; i++, j--) {
            char temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
        }
    }
}