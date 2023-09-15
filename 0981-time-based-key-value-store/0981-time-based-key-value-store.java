class TimeMap {
    Map<String, List<Pair<String, Integer>>> map;
    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        List<Pair<String, Integer>> list = map.getOrDefault(key, new ArrayList<Pair<String, Integer>>());
        list.add(new Pair(value, timestamp));
        map.put(key, list);
    }
    
    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) return "";
        List<Pair<String, Integer>> list = map.get(key);
        // System.out.println(list.size());
        int i = 0;
        int j = list.size() - 1;
        String res = "";
        while (i <= j) {
            int mid = i + (j - i) / 2;
            if (list.get(mid).getValue() <= timestamp) {
                res = list.get(mid).getKey();
                i = mid + 1;
            } else{
                j = mid - 1;
            }
        }
        return res;
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */