class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int[] rest = new int[gas.length];
        for (int i = 0; i < gas.length; i++) {
            rest[i] = gas[i] - cost[i];
        }
        int start = 0, sum = 0, total = 0;
        for (int i = 0; i < rest.length; i++) {
            sum += rest[i];
            total += rest[i];
            if (sum < 0) {
                sum = 0;
                start = (i + 1) % rest.length;
            }
        }
        if (total < 0) return -1;
        return start;
    }
}