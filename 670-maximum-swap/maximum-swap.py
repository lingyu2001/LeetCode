class Solution(object):
    def maximumSwap(self, num):
        """
        :type num: int
        :rtype: int
        """
        # max_val_idx = , left=0, right=1

        num_str = list(str(num))
        max_val_idx = len(num_str) - 1
        left = -1
        right = -1
        for i in range(len(num_str) - 2, -1, -1):
            if num_str[i] > num_str[max_val_idx]:
                max_val_idx = i
            elif num_str[i] < num_str[max_val_idx]:
                left = i
                right = max_val_idx
        num_str[left], num_str[right] = num_str[right], num_str[left]
        return int("".join(num_str))