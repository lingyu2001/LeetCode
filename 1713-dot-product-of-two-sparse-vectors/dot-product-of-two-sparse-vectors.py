class SparseVector:
    def __init__(self, nums):
        """
        :type nums: List[int]
        """
        self.non_zeros = []
        for idx, n in enumerate(nums):
            if n != 0:
                self.non_zeros.append([idx, n])

    def dotProduct(self, vec):
        """
        :type vec: 'SparseVector'
        :rtype: int
        """
        res = 0
        p = 0
        q = 0
        while p < len(self.non_zeros) and q < len(vec.non_zeros):
            if self.non_zeros[p][0] == vec.non_zeros[q][0]:
                res += self.non_zeros[p][1] * vec.non_zeros[q][1]
                p += 1
                q += 1
            elif self.non_zeros[p][0] < vec.non_zeros[q][0]:
                p += 1
            else:
                q += 1
        return res