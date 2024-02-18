class TimeMap {

    HashMap<String, List<Pair<Integer, String>>> map;
    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        map.computeIfAbsent(key, k -> new ArrayList<Pair<Integer, String>>()).add(new Pair<>(timestamp, value));
    }
    
    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) return "";
        List<Pair<Integer, String>> list = map.get(key);
        int max = 0;
        String res = "";
        int l = 0, r = list.size() - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            int t = list.get(mid).getKey();
            String val = list.get(mid).getValue();
            if(list.get(mid).getKey() <= timestamp) {
                max = Math.max(max, t);
                res = val;
                l = mid + 1;
            } else {
                r = mid - 1;
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