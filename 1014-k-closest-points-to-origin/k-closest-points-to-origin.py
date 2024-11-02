class Solution:
    def kClosest(self, points: List[List[int]], k: int) -> List[List[int]]:
        return self.quick_select(points, k)
    
    def quick_select(self, points: List[List[int]], k: int) -> List[List[int]]:
        """Perform the QuickSelect algorithm on the list"""
        left = 0
        right = len(points) - 1
        pivot_idx = len(points)
        while pivot_idx != k:
            pivot_idx = self.partition(points, left, right)
            if pivot_idx > k:
                right = pivot_idx - 1
            elif pivot_idx < k:
                left = pivot_idx
        # Return the first k elements of the partially sorted list
        return points[:k]
    
    def partition(self, points: List[List[int]], left: int, right: int) -> int:
        """Partition the list around the pivot value"""
        pivot = self.choose_pivot(points, left, right)
        pivot_dis = self.squared_distance(points[pivot])
        while left < right:
            if self.squared_distance(points[left]) >= pivot_dis:
                points[left], points[right] = points[right], points[left]
                right -= 1
            else:
                left += 1
        if self.squared_distance(points[left]) < pivot_dis:
            left += 1
        return left
        

    
    def choose_pivot(self, points: List[List[int]], left: int, right: int) -> List[int]:
        """Choose a pivot element of the list"""
        return left + (right - left) // 2
    
    def squared_distance(self, point: List[int]) -> int:
        """Calculate and return the squared Euclidean distance."""
        return point[0] ** 2 + point[1] ** 2