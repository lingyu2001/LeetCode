class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int i: stones)  heap.add(-i);
        while (heap.size() >= 2) {
            int x = heap.poll();
            int y = heap.poll();
            if (x != y) heap.add(x - y);
        }
        if(heap.size() == 1) {
            return -heap.poll();
        } else return 0;
    }
}