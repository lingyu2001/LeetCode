class Solution(object):
    def findRLEArray(self, encoded1, encoded2):
        """
        :type encoded1: List[List[int]]
        :type encoded2: List[List[int]]
        :rtype: List[List[int]]
        """
        p1 = 0
        p2 = 0
        res = []
        while p1 < len(encoded1) and p2 < len(encoded2):
            cnt1 = encoded1[p1][1]
            cnt2 = encoded2[p2][1]
            if cnt1 == cnt2:
                if res and encoded1[p1][0] * encoded2[p2][0] == res[-1][0]:
                    res[-1][1] += cnt1
                else:
                    res.append([encoded1[p1][0] * encoded2[p2][0], cnt1])
                p1 += 1
                p2 += 1
            elif cnt1 < cnt2:
                if res and encoded1[p1][0] * encoded2[p2][0] == res[-1][0]:
                    res[-1][1] += cnt1
                else:
                    res.append([encoded1[p1][0] * encoded2[p2][0], cnt1])
                p1 += 1
                encoded2[p2][1] = cnt2 - cnt1
            else:
                if res and encoded1[p1][0] * encoded2[p2][0] == res[-1][0]:
                    res[-1][1] += cnt2
                else:
                    res.append([encoded1[p1][0] * encoded2[p2][0], cnt2])
                p2 += 1
                encoded1[p1][1] = cnt1 - cnt2
        return res
        