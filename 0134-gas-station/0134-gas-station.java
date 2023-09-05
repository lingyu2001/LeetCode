class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int[] arr = new int[gas.length];
        int sum = 0;
        for (int i = 0; i < gas.length; i++) {
            arr[i] = gas[i] - cost[i];
            sum += arr[i];
        }
        if (sum < 0) return -1;
        int index = 0;
        sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (sum < 0)  {
                index = i + 1;
                sum = 0;
            }
        }
        return index;
    }
}