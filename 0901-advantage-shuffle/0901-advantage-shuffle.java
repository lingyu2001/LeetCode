class Solution {
    public int[] advantageCount(int[] nums1, int[] nums2) {
        // sort nums2
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> b[1] - a[1]);
        for (int i = 0; i < nums2.length; i++) {
            pq.offer(new int[]{i, nums2[i]});
        }
        // sort nums1
        int[] res = new int[nums1.length];
        Arrays.fill(res, -1);
        Arrays.sort(nums1);
        int left = 0, right = nums1.length - 1;
        while (!pq.isEmpty()) {
            int[] m = pq.poll();
            int idx = m[0], num = m[1];
            if (nums1[right] > num) {
                res[idx] = nums1[right];
                right--;
            } else {
                res[idx] = nums1[left];
                left++;
            }
        }
        return res;
    }
}