class TimeMap {
    Map<String, List<Pair<String, Integer>>> map;
    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        List<Pair<String, Integer>> list = map.getOrDefault(key, new ArrayList<>());
        list.add(new Pair(value, timestamp));
        map.put(key, list);
    }
    
    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) return "";
        List<Pair<String, Integer>> list = map.get(key);
        // return search(list, timestamp);
        return search(timestamp, list);
    }

    public String search(int t, List<Pair<String, Integer>> list) {
        int right = list.size() - 1;
        int left = 0;
        String res = "";
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (list.get(mid).getValue() <= t) {
                left = mid + 1; 
                res = list.get(mid).getKey();
            }else right = mid - 1;
        }
        return res;
    }

    // public String search(List<Pair<String, Integer>> list, int timestamp) {
    //     int start = 0;
    //     int end = list.size() - 1;
    //     while (start < end) {
    //         int mid = start + (end - start + 1) / 2;
    //         if (list.get(mid).getValue() <= timestamp) start = mid; else end =
    //             mid - 1;
    //     }
    //     return list.get(start).getValue() <= timestamp
    //         ? list.get(start).getKey()
    //         : "";
    // }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */