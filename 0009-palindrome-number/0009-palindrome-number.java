class Solution {
    public boolean isPalindrome(int x) {
        if (x == 0) return true;
        if (x < 0 || x % 10 == 0) return false;
        int right = 0, left = x;
        while (left > right) {
            int digit = left % 10;
            right = right * 10 + digit;
            left = left / 10;
        }
        return left == right || left == right / 10;
    }
}