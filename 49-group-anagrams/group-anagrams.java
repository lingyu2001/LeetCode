class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // create a map<encode, list<string>>
        // itertate the string array, for each str in the array, if the encode of the str
        // exists in the map, then we add the str to the corresponding list; else we add the encode of the str and 
        // a list which contains the str to the list
        // return the values of the map
        // time complexity is O(kN)
        HashMap<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            String encodingStr = encode(s);
            if (map.containsKey(encodingStr)) {
                List<String> list = map.get(encodingStr);
                list.add(s);
                map.put(encodingStr, list);
            } else {
                List<String> list = new ArrayList<>();
                list.add(s);
                map.put(encodingStr, list);
            }
        }
        List<List<String>> res = new ArrayList<>();
        for (List<String> list : map.values()) {
            res.add(list);
        }
        /*
            Initialization:
            char c = '\u0000'; initializes c to the null character, which is the first character in the Unicode character set and has a numerical value of 0.

            Increment Operation:
            c++; increments the value of c. Since c was 0 (null character), incrementing it by 1 will change its value to 1.
            
            Output:
            System.out.println(c); will then print the character that corresponds to the Unicode value 1. This character is a control character in the Unicode set and is typically not visible or represented as a space in most fonts and systems.
            Thus, the output of this code will be a representation of the character with Unicode value 1, which is usually not visible. In some environments, it might appear as a space or a special symbol, or there might be no visible output at all.
        */
        // char c = '\u0000';
        // c++;
        // System.out.println(c);
        return res;
    }

    public String encode(String s) {
        char[] count = new char[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }
        return new String(count);
    }
}