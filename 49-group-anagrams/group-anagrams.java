class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // hashmap<string, List<String>>
        // 1. first, iterate each word in the strs array,
        // for each word,  
            // 1.1 calculate the encode string of the word. 
            // 1.2 check if the encode is in the hashmap table
            // => yes, add the word to the corresponding list
            // => no, we create a new list, add the encode and the list to the hashmap table
        // 2. create the result => iterate each value in the hashmap and add them to the result list
        // 3. return the result

        // how to encode the word? => count the frequency of each character and convert it to the string
        List<List<String>> res = new ArrayList<>();
        HashMap<String, List<String>> map = new HashMap<>();
        for (String w : strs) {
            String encode = encoder(w);
            // check if the encode is in the hashmap table
            List<String> list;
            if (map.containsKey(encode)) {
                // yes
                list = map.get(encode);
            } else {
                // no
                list = new ArrayList<>();
            }
            list.add(w);
            map.put(encode, list);
        }
        for (List<String> list : map.values()) {
            res.add(list);
        }
        return res;
    }

    public String encoder(String w) {
        char[] chars = new char[26];
        for (char c : w.toCharArray()) {
            chars[c - 'a']++;
        }
        return String.valueOf(chars);
    }
}