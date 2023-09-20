class Solution {
    public boolean canConstruct(String randomNote, String magazine) {
        if (randomNote.length() > magazine.length()) return false;
        int[] arr = new int[26];
        for (int i = 0; i < randomNote.length(); i++) {
            arr[randomNote.charAt(i) - 'a']--;
            arr[magazine.charAt(i) - 'a']++;
        }
        for (int i = randomNote.length(); i < magazine.length(); i++) {
            arr[magazine.charAt(i) - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            // System.out.println(i +","+arr[i]);
            if (arr[i] < 0) return false;
        }
        return true;
    }
}