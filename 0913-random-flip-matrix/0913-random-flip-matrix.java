class Solution {
    int m,n;
    int len;
    HashMap<Integer, Integer> map;
    public Solution(int m, int n) {
        this.m = m;
        this.n = n;
        this.len = m * n;
        this.map = new HashMap<>();
    }
    
    public int[] flip() {
        Random random = new Random();
        int rand = random.nextInt(len);
        int res = rand;
        if (map.containsKey(res)) {
            res = map.get(rand);
        }
        int last = len - 1;
        if (map.containsKey(last)) {
            last = map.get(last);
        }
        map.put(rand, last);
        len--;
        return new int[] {res / n, res % n};
    }
    
    public void reset() {
        len =  this.m * this.n;
         map.clear();
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(m, n);
 * int[] param_1 = obj.flip();
 * obj.reset();
 */