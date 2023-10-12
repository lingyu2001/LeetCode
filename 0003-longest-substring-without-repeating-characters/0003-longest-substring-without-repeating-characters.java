class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0, right = 0;
        int[] arr = new int[256];
        int max = 0;
        while (right < s.length()) {
            char r = s.charAt(right);
            right++;
            arr[r]++;
            while (arr[r] > 1) {
                char l = s.charAt(left);
                arr[l]--;
                left++;
            }
            max = Math.max(max, right - left);
        }
        return max;
    }
}