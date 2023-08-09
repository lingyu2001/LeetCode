class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // create a hashmap
        // iterate each word, sort the word, check if it is in hashmap, if yes, add the original word to the list, otherwise, 
        // create a new list for the value
        Map<String, List<String>> m = new HashMap<>();
        for (String s: strs) {
            String ss = new String(s);
            // System.out.println(ss==s);
            char[] c = s.toCharArray(); 
            Arrays.sort(c);
            // System.out.println(c);
            String hash = Arrays.toString(c);
            if (m.containsKey(hash)) {
                List<String> l = m.get(hash);
                l.add(ss);
                m.put(hash,l);
            }else {
                List<String> l = new ArrayList<String>();
                l.add(ss);
                m.put(Arrays.toString(c), l);
            }
        }
        List<List<String>> res = new ArrayList<>();
        res.addAll(m.values());
        return res;
    }
}