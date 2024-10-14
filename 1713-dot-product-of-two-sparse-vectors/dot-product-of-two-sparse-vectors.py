class SparseVector:
    def __init__(self, nums):
        """
        :type nums: List[int]
        """
        self.non_zero_pos = {}
        for idx, n in enumerate(nums):
            if n != 0: 
                self.non_zero_pos[idx] = n
        

    # Return the dotProduct of two sparse vectors
    def dotProduct(self, vec):
        """
        :type vec: 'SparseVector'
        :rtype: int
        """
        res = 0
        for idx, n in self.non_zero_pos.items():
            if idx in vec.non_zero_pos:
                res += n * vec.non_zero_pos[idx]
        return res

# Your SparseVector object will be instantiated and called as such:
# v1 = SparseVector(nums1)
# v2 = SparseVector(nums2)
# ans = v1.dotProduct(v2)