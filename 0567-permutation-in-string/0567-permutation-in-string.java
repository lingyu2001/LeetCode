class Solution {
    public boolean checkInclusion(String s1, String s2) {
        // window: int[] arr
        // pointers: left, right
        // how to move the window:
            // keep moving the right pointer until all the letters in s1 are included in s2, then move the left pointer 
                // then test if the len of substring of s2 is equal to s1 ==> yes, return true;
            //until the window doesnt include all letters in s2;
        // return false;
        int left = 0, right = 0, valid = 0;
        int[] arr1 = new int[256];
        int[] arr2 = new int[256];
        HashSet<Character> set = new HashSet<>();
        for (char c : s1.toCharArray()) {
            arr1[c]++;
            set.add(c);
        }
        while (right < s2.length()) {
            char r = s2.charAt(right);
            right++;
            if (arr1[r] > 0) {
                arr2[r]++;
                if (arr2[r] == arr1[r]) valid++;
            }
            while (valid == set.size()) {
                char l = s2.charAt(left);
                if (right - left == s1.length()) return true;
                left++;
                if (set.contains(l)) {
                    arr2[l]--;
                    if (arr2[l] < arr1[l]) valid--;
                }
            }
        }
        return false;
    }
}