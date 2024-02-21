class KthLargest {
    /*
    1. create a pq in an ascending order.
    2. in the constructor, we add each elements to the pq. 
        2.1 call add(element)
    3.  in the add function, after we add the element , check the size of pq. if it is. > k, then we poll. return the peek of the pq
    */
    PriorityQueue<Integer> pq;
    int k;
    public KthLargest(int k, int[] nums) {
        pq = new PriorityQueue<>();
        this.k = k;
        for (int n : nums) {
            add(n);
        }
    }
    
    public int add(int val) {
        pq.add(val);
        //check the size of pq
        if (pq.size() > k) {
            pq.poll();
        }
        return pq.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */