class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // map <String, List<String>>
        // iterate the whole list
        // for each string, => sort the string 
        // if the sorted string is in the map, then we put the original string in the list
        // else we create a new list, and put the string in the list, and put them in the map
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String sortedStr = new String(chars);
            if (map.containsKey(sortedStr)) {
                List<String> list = map.get(sortedStr);
                list.add(s);
                map.put(sortedStr, list);
            } else {
                List<String> list = new LinkedList<>();
                list.add(s);
                map.put(sortedStr, list);
            }
        }
        List<List<String>> res = new LinkedList<>();
        for (List<String> strings : map.values()) {
            res.add(strings);
        }
        return res;
    }
}