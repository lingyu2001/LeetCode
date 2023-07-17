class Solution {
    public int maxNumberOfBalloons(String text) {
        int[] chars = new int[26];
        for (char c : text.toCharArray()) {
            chars[c - 'a']++;
        }
        int min = Integer.MAX_VALUE;
        for (char c:"balloon".toCharArray()) {
            min = Math.min(min, chars[c - 'a']);
        }
        while ((2 * min > chars['l' - 'a']) || (2 * min > chars['o' - 'a'])) {
            min--;
        }
        return min;
    }
}