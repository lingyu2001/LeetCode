class Solution {
    Set<Integer> set = new HashSet<>();
    public boolean isHappy(int n) {
        while (true) {
            int sum = 0;
            while (n != 0) {
                sum += (n % 10) * (n % 10);
                n = n / 10;
            }
            // System.out.println(sum);
            if (sum == 1) return true;
            else if (set.contains(sum)) return false;
            else { 
                set.add(sum);
                n = sum;
            }
        }
    }
}