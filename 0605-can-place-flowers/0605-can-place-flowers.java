class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 0 && i - 1 >= 0 && flowerbed[i - 1] == 0 && i + 1 < flowerbed.length && flowerbed[i + 1] == 0) {
                n--;
                flowerbed[i] = 1;
            }else if (flowerbed[i] == 0 && i - 1 < 0 && i + 1 >= flowerbed.length) {
                if (flowerbed[i] == 0) return true;
            }else if (flowerbed[i] == 0 && i - 1 < 0) {
                if (flowerbed[i + 1] == 0) {
                    flowerbed[i] = 1;
                    n--;
                }
            } else if (flowerbed[i] == 0 && i + 1 >= flowerbed.length) {
                if (flowerbed[i - 1] == 0) {
                    flowerbed[i] = 1;
                    n--;
                }
            }
        }
        return n <= 0;
    }
}