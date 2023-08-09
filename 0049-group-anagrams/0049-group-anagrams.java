class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // create a hashmap
        // iterate each word, sort the word, check if it is in hashmap, if yes, add the original word to the list, otherwise, 
        // create a new list for the value
        Map<String, List<String>> m = new HashMap<>();
        for (String s: strs) {
            int[] c = new int[26];
            for (char cc: s.toCharArray()) {
                c[cc - 'a']++;
            }
            String hash = Arrays.toString(c);
            if (m.containsKey(hash)) {
                m.get(hash).add(s);
            } else {
                m.put(hash, new ArrayList<>());
                m.get(hash).add(s);
            }
        }
        List<List<String>> res = new ArrayList<>();
        res.addAll(m.values());
        return res;
    }
}