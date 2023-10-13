class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        //convert s to 
        int[] nums = new int[s.length()];
        HashSet<Integer> seen = new HashSet<>();
        HashSet<String> res = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            switch (s.charAt(i)) {
                case 'A':
                    nums[i] = 0;
                    break;
                case 'G':
                    nums[i] = 1;
                    break;
                case 'C':
                    nums[i] = 2;
                    break;
                case 'T':
                    nums[i] = 3;
                    break;
            }
        }
        int L = 10;
        int R = 4;
        int RL = (int)Math.pow(R, L - 1);
        int windowHash = 0, left = 0, right = 0;
        while (right < nums.length) {
            windowHash = windowHash * R + nums[right];
            right++;
            if (right - left == L) {
                if (seen.contains(windowHash)) {
                    res.add(s.substring(left, right));
                } else {
                    seen.add(windowHash);
                }
                windowHash -= nums[left] * RL;
                left++;
            }

        }
        return new LinkedList<>(res);
    }
}