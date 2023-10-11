class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int l = 0, r = arr.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] == x) {
                l = mid;
                break;
            }else if (arr[mid] > x) r = mid - 1;
            else l = mid + 1;
        }
        // System.out.println(l + "," + r);
        int left = l - 1, right = l;
        LinkedList<Integer> res = new LinkedList<>();
        while (right - left - 1 < k) {
            if (left == -1) {
                res.addLast(arr[right]);
                right++;
            } else if (right >= arr.length) {
                res.addFirst(arr[left]);
                left--;
            } else if (Math.abs(arr[right] - x) < Math.abs(arr[left] - x)) {
                res.addLast(arr[right]);
                right++;
            } else {
                res.addFirst(arr[left]);
                left--;
            }
        }
        return res;
    }
}