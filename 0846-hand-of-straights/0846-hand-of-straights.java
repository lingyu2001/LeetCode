class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int n = hand.length;
        if (n % groupSize != 0) return false;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(hand[i], map.getOrDefault(hand[i], 0) + 1);
        }
        while (map.size() != 0) {
            int minKey = Collections.min(map.keySet());
            for (int i = 0; i < groupSize; i++) {
                int target = minKey + i;
                // System.out.println(target);
                int num = map.getOrDefault(target, 0) - 1;
                if (num < 0) return false;
                else if (num == 0) map.remove(target);
                else map.put(target, num);
            }
        }
        return true;
    }
}