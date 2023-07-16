class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> s = new Stack<>();
        for (int i = 0; i < asteroids.length; i++) {
            if (s.isEmpty() || s.peek() < 0) s.push(asteroids[i]);
            else {
                // last asteroids > 0
                // a[i] > 0
                // same signs
                if (asteroids[i] > 0) s.push(asteroids[i]);
                // different signs
                else {
                    //a[i] < 0, s.peek()>0
                    while (!s.isEmpty() && s.peek() > 0 && asteroids[i] + s.peek() < 0) {
                        s.pop();
                    }
                    if (s.isEmpty()) s.push(asteroids[i]);
                    else if (s.peek() + asteroids[i] == 0) {
                        s.pop();
                        continue;
                    }else if (s.peek() < 0) s.push(asteroids[i]); 
                }
            }
        }
        int[] ret = new int[s.size()];
        for (int i = ret.length - 1; i >= 0; i--) {
            ret[i] = s.pop();
        }
        return ret;
    }
}