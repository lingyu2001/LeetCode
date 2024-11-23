class Solution(object):
    def rotateTheBox(self, box):
        """
        :type box: List[List[str]]
        :rtype: List[List[str]]
        """
        m = len(box)
        n = len(box[0])
        box_rotated = [['.'] * m for i in range(n)]
        for i in range(n):
            for j in range(m):
                box_rotated[i][j] = box[m - 1 - j][i]
        for i in range(m):
            j = n - 1
            k = j
            while k >= 0:
                if box_rotated[k][i] == '#':
                    box_rotated[j][i] = '#'
                    j -= 1
                elif box_rotated[k][i] == '*':
                    while j > k:
                        box_rotated[j][i] = '.'
                        j -= 1
                    j = k - 1
                k -= 1
            while j >= 0:
                box_rotated[j][i] = '.'
                j -= 1
        return box_rotated


        