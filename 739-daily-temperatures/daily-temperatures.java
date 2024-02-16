class Solution {
    public int[] dailyTemperatures(int[] temp) {
        // BF: O(n^2)
        // merhod2 : O(n), use stack
        // 1. iterate the array, (idx, t)
        // 1.1 if the stack is empty, then push (t, idx) into the stack
        //     else keep comparing the current temperature to the temp of 
        //      the peek of the stack, if the current one is larger, then fill 
        //      in the array 
        // 1.2    stop comparing when the current temp is smaller, instead, add the 
        //      (current one, idx) to the stack
        // 2.   finish iterating. pop all the pairs in the stack, fill in the array
        //      with zero
        // 3. return the result
        Stack<Pair<Integer, Integer>> stack = new Stack<>();
        int[] res = new int[temp.length];
        for (int i = 0; i < temp.length; i++) {
            while (!stack.isEmpty() && stack.peek().getKey() < temp[i]) {
                int pastT = stack.peek().getKey(); // get the past temp
                int idx = stack.peek().getValue();
                stack.pop();
                res[idx] = i - idx;
            }
            stack.push(new Pair<>(temp[i], i));
        }
        while(!stack.isEmpty()) {
            res[stack.pop().getValue()] = 0;
        }
        return res;
    }
}