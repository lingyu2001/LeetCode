class Solution {

    public boolean mergeTriplets(int[][] triplets, int[] target) {
        boolean[] b = new boolean[3];
        loop: for (int[] tri : triplets) {
            for (int i = 0; i < 3; i++) {
                if (tri[i] > target[i]) continue loop;
            }
            for (int i = 0; i < 3; i++) {
                if (tri[i] == target[i]) b[i] = true;
            }
        }
        return b[0] && b[1] && b[2];
    }
}
