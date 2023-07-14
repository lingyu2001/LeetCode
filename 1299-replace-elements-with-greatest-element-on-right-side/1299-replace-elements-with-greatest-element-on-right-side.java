class Solution {
    public int[] replaceElements(int[] arr) {
        int max = 0, index = 0;
        for (int i = 0; i < arr.length; i++) {
            if (i < index) arr[i] = arr[index];
            else {
                max = 0;
                for (int j = index + 1; j < arr.length; j++) {
                    if (max < arr[j]) {
                        max = arr[j];
                        index = j;
                    }
                }
                arr[i] = arr[index];
            }
        }
        arr[arr.length - 1] = -1;
        return arr;
    }
}