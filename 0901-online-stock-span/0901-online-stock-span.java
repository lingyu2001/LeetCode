class StockSpanner {
    
    Stack<Integer> prices;
    Stack<Integer> cnt;
    LinkedList<Integer> l = new LinkedList<>();
    public StockSpanner() {
        prices = new Stack<>();
        cnt = new Stack<>();
    }
    
    public int next(int price) {
        int ret = 1;
        while (!prices.isEmpty() && price >= prices.peek()) {
             ret += cnt.pop();
             prices.pop();
        }
        prices.push(price);
        cnt.push(ret);
        return ret;
    }
}

/**  
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */