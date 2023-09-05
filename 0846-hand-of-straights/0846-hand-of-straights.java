class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int n = hand.length;
        if (n % groupSize != 0) return false;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(hand[i], map.getOrDefault(hand[i], 0) + 1);
        }
        Arrays.sort(hand);
        for (int t : hand) {
            if (map.get(t) == 0) continue;
            for (int i = 0; i < groupSize; i++) {
                int target = t + i;
                int num = map.getOrDefault(target, 0) - 1;
                if (num < 0) return false;
                else map.put(target, num);
            }
        }
        return true;
    }
}