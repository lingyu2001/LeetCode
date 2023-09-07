class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        int[][] com = new int[n][2];
        for (int i = 0; i < n; i++) {
            com[i][0] = position[i];
            com[i][1] = speed[i];
        }
        Stack<Double> stack = new Stack<>();
        Arrays.sort(com, (a,b) -> a[0] - b[0]);
        for (int i = n - 1; i >= 0; i--) {
            double cur = (double) (target - com[i][0]) / com[i][1];
            if (!stack.isEmpty() && cur <= stack.peek()) continue;
            else stack.push(cur);
        }
        return stack.size();
    }
}