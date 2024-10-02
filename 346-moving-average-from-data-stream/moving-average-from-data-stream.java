class MovingAverage {
    LinkedList<Integer> list;
    int sum = 0;
    int window ;
    public MovingAverage(int size) {
        this.window = size;
        list = new LinkedList<>();
    }
    
    public double next(int val) {
        if (list.size() < window) {
            sum += val;
            list.add(val);
            return sum * 1.0 / list.size();
        } else {
            sum -= list.removeFirst();
            sum += val;
            list.add(val);
            return sum * 1.0 / window;
        }
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */