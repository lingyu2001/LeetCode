class RandomizedSet {
    int[] arr;
    int length = 0;
    HashMap<Integer, Integer> map;
    public RandomizedSet() {
        arr = new int[200000];
        map = new HashMap<>();
    }
    
    public boolean insert(int val) {
        if (map.containsKey(val)) return false;
        map.put(val, length);
        arr[length] = val;
        length++;
        return true;
    }
    
    public boolean remove(int val) {
        if (!map.containsKey(val)) return false;
        int index = map.get(val);
        arr[index] = arr[length - 1];
        map.put(arr[length - 1], index);
        length--;
        map.remove(val);
        return true;
    }
    
    public int getRandom() {
        int randomIndex = (int) Math.floor(Math.random() * length);
        return arr[randomIndex];
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */