class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int left = 1, right = 0;
        for (int i = 0; i < weights.length; i++) {
            left = Math.max(left, weights[i]);
            right += weights[i];
        }
        int res = right;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            System.out.println(mid+ " " + days1(weights, mid));
            if (days1(weights, mid) > days) {
                left = mid + 1;
            } else {
                res = Math.min(res, mid);
                right = mid - 1;
            }
        }
        return res;
    }
    
    public int days1(int[] weights, int weight) {
        int sum = 0, days = 0,j = 0;
        while (j < weights.length) {
            if (sum + weights[j] < weight) {
                sum += weights[j];
            } else if (sum + weights[j] == weight) {
                sum = 0;
                days++;
            }else {
                sum = weights[j];
                days++;
            }
            j++;
        }
        return sum == 0 ? days : days + 1;
    }
}