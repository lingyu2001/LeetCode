class Solution {
    public boolean isHappy(int n) {
        int nn = n;
        Set<Integer> set = new HashSet<>();
        while (true) {
            int sum = 0;
            while (n > 0) {
                int digit = n % 10;
                sum += digit * digit;
                n = n / 10;
            }
            // System.out.println(sum);
            if (set.contains(sum))
                return false;
            else if (sum == 1)
                return true;
            else {
                set.add(sum);
                n = sum;
            }
        }
    }
}