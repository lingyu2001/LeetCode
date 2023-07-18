class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int sum = 0, l = 0, cnt = 0;
        for(int i = 0; i < k - 1; i++) {
            sum += arr[i];
        }
        for (int r = l + k - 1; r < arr.length; r++) {
            if ((sum + arr[r]) / k >= threshold) {
                cnt++;
            } 
            sum -= arr[l++];
            sum += arr[r];
        }
        return cnt;
    }
}