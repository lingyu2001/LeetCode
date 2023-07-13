class Solution {
    //1207
    List<List<String>> res = new ArrayList<>();
    Map<String,List<String>> map =  new HashMap<>();
    public List<List<String>> groupAnagrams(String[] strs) {
        // iterate each str in strs
        // for each str 
            // calculate the hashValue of str(the count of the charatcers in the str)
            // if the hash is not in the map --> create a key and add the str 
            // if it is already in the map --> add the str to the list
        // iterate the whole key in map and add all values in res;
        for (String str : strs) {
            int[] cnt = new int[26];
            // count the value
            for (char c : str.toCharArray()) {
                cnt[c - 'a']++;
            }
            String key = Arrays.toString(cnt);
            if (map.containsKey(key)) {
                map.get(key).add(str);
            } else {
                map.put(key, new ArrayList<>());
                map.get(key).add(str);
            }
        }
        res.addAll(map.values());
        return res;
    }
}